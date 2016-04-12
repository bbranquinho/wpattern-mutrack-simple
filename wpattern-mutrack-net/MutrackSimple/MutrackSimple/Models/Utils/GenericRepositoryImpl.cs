using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MutrackSimple.Models.Utils
{
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
            throw new NotImplementedException();
        }

        public T Delete(PK pk)
        {
            throw new NotImplementedException();
        }

        public void Delete(T entity)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<T> Find(Func<T, bool> where)
        {
            throw new NotImplementedException();
        }

        public T First()
        {
            throw new NotImplementedException();
        }

        public T First(Func<T, bool> where)
        {
            throw new NotImplementedException();
        }

        public T FirstOrDefault(Func<T, bool> where)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<T> GetAll()
        {
            throw new NotImplementedException();
        }

        public IQueryable<T> GetQuery()
        {
            return Set.AsQueryable();
        }

        public void SaveChanges()
        {
            throw new NotImplementedException();
        }

        public T Single(Func<T, bool> where)
        {
            throw new NotImplementedException();
        }

        public void Update(T entity)
        {
            throw new NotImplementedException();
        }
        #endregion
    }
}