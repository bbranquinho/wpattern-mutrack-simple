using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Web.Http;
using System.Web.Http.Description;
using MutrackSimple.Models;
using MutrackSimple.Models.Repositories;
using MutrackSimple.Models.Repositories.Impl;

namespace MutrackSimple.Controllers
{
    //[EnableCors(origins: "*", headers: "*", methods: "*")]
    public class PackageController : ApiController
    {
        private PackageRepository Repository { get; set; }

        public PackageController()
        {
            var context = new MutrackSimpleEntities();

            Repository = new PackageRepositoryImpl(context);
        }

        // GET: api/Package
        public IQueryable<PackageEntity> GetPackages()
        {
            return Repository.GetQuery();
        }

        // GET: api/Package/5
        [ResponseType(typeof(PackageEntity))]
        public IHttpActionResult GetPackageEntity(int id)
        {
            PackageEntity packageEntity = Repository.Single(id);

            if (packageEntity == null)
            {
                return NotFound();
            }

            return Ok(packageEntity);
        }

        // PUT: api/Package
        [ResponseType(typeof(void))]
        public IHttpActionResult PutPackageEntity(PackageEntity entity)
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
                if (!PackageEntityExists(entity.Pk))
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

        // POST: api/Package
        [ResponseType(typeof(PackageEntity))]
        public IHttpActionResult PostPackageEntity(PackageEntity entity)
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
                if (PackageEntityExists(entity.Pk))
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

        // DELETE: api/Package/5
        [ResponseType(typeof(PackageEntity))]
        public IHttpActionResult DeletePackageEntity(int id)
        {
            try
            {
                return Ok(Repository.Delete(id));
            }
            catch (Exception)
            {
                return NotFound();
            }
        }

        private bool PackageEntityExists(int id)
        {
            return Repository.Count(e => e.Id == id) > 0;
        }
    }
}