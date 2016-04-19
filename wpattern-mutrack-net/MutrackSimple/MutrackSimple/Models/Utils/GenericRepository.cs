using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http.Cors;

namespace MutrackSimple.Models.Utils
{
    public interface GenericRepository<T, PK> where T : BaseEntity<PK>
    {
        IQueryable<T> GetQuery();
        IEnumerable<T> GetAll();
        IEnumerable<T> Find(Func<T, bool> where);
        T Single(PK pk);
        T Single(Func<T, bool> where);
        T First();
        T First(Func<T, bool> where);
        T FirstOrDefault(Func<T, bool> where);
        void Add(T entity);
        void Delete(T entity);
        T Delete(PK pk);
        void Update(T entity);
        int SaveChanges();
    }
}