using MutrackSimple.Models;
using MutrackSimple.Models.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Http.Description;

namespace MutrackSimple.Controllers.Utils
{
    public abstract class GenericControllerImpl<T, PK> : ApiController, GenericController<T, PK> where T : BaseEntity<PK>
    {
        #region Properties
        protected GenericRepository<T, PK> Repository { get; set; }

        private Type asdd = typeof(PackageEntity);
        #endregion

        #region Constructors
        public GenericControllerImpl(GenericRepository<T, PK> repository)
        {
            Repository = repository;
        }
        #endregion

        #region Service Methods
        // GET: api/T
        public IQueryable<T> Get()
        {
            return Repository.GetQuery();
        }

        // GET: api/T/id
        public IHttpActionResult Get(PK id)
        {
            T entity = Repository.Single(id);

            if (entity == null)
            {
                return NotFound();
            }

            return Ok(entity);
        }
        #endregion
    }
}