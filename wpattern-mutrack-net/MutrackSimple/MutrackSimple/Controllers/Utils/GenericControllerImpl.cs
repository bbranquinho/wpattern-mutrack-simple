using MutrackSimple.Models;
using MutrackSimple.Models.Utils;
using System;
using System.Collections.Generic;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Http;
using System.Web.Http.Description;

namespace MutrackSimple.Controllers.Utils
{
    public abstract class GenericControllerImpl<T, PK> : ApiController, GenericController<T, PK> where T : BaseEntity<PK>
    {
        #region Properties
        protected GenericRepository<T, PK> Repository { get; set; }
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

        // PUT: api/{Entity}
        [ResponseType(typeof(void))]
        public IHttpActionResult Put(T entity)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            try
            {
                Repository.Update(entity);
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!EntityExists(entity.Pk))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/{Entity}
        public IHttpActionResult Post(T entity)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            try
            {
                Repository.Add(entity);
            }
            catch (DbUpdateException)
            {
                if (EntityExists(entity.Pk))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = entity.Pk }, entity);
        }

        // DELETE: api/{entity}/5
        public IHttpActionResult Delete(PK pk)
        {
            try
            {
                return Ok(Repository.Delete(pk));
            }
            catch (Exception)
            {
                return NotFound();
            }
        }

        private bool EntityExists(PK pk)
        {
            return Repository.Count(e => e.Pk.Equals(pk)) > 0;
        }
        #endregion
    }
}