using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Web;
using System.Web.Http.Cors;

namespace MutrackSimple.Models.Utils
{
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    public abstract class GenericRepositoryImpl<T, PK> : GenericRepository<T, PK> where T : BaseEntity<PK>
    {
        #region Properties
        public DbContext Context { get; set; }

        public DbSet<T> Set { get; set; }
        #endregion

        #region Constructor
        public GenericRepositoryImpl(DbContext context)
        {
            Context = context;
            Set = context.Set<T>();
        }
        #endregion

        #region Methods (GenericRepository)
        public void Add(T entity)
        {
            Set.Add(entity);
            SaveChanges();
        }

        public T Delete(PK pk)
        {
            var entity = Single(pk);

            if (entity != null)
            {
                Set.Remove(entity);
                SaveChanges();
            }
            else
            {
                //Log.Error("Entity not founded to be deleted {0}.", pk);
                throw new NotImplementedException();
            }

            return entity;
        }

        public void Delete(T entity)
        {
            Set.Remove(entity);
            SaveChanges();
        }

        public IEnumerable<T> Find(Func<T, bool> where)
        {
            return Set.Where(where);
        }

        public T First()
        {
            return Set.First();
        }

        public T First(Func<T, bool> where)
        {
            return Set.First(where);
        }

        public T FirstOrDefault(Func<T, bool> where)
        {
            return Set.FirstOrDefault<T>(where);
        }

        public IEnumerable<T> GetAll()
        {
            return Set.AsEnumerable();
        }

        public IQueryable<T> GetQuery()
        {
            return Set.AsQueryable();
        }

        public int SaveChanges()
        {
            return Context.SaveChanges();
        }

        public T Single(PK pk)
        {
            return Set.Find(pk);
            Context.SaveChanges();
        }

        public T Single(Func<T, bool> where)
        {
            return Set.Single(where);
        }

        public void Update(T newEntity)
        {
            var entityEntry = Context.Entry(newEntity);

            if ((entityEntry.State != EntityState.Modified) && Exists(newEntity))
            {
                Set.Attach(newEntity);
                entityEntry.State = EntityState.Modified;
            }

            SaveChanges();
        }
        #endregion

        #region Protected Methods
        protected Boolean Exists(T entity)
        {
            var objectContext = ((IObjectContextAdapter)Context).ObjectContext;
            var objectSet = objectContext.CreateObjectSet<T>();
            var entityKey = objectContext.CreateEntityKey(objectSet.EntitySet.Name, entity);
            Object foundEntity;
            var exists = objectContext.TryGetObjectByKey(entityKey, out foundEntity);

            if (exists)
            {
                objectContext.Detach(foundEntity);
            }

            return exists;
        }
        #endregion
    }
}