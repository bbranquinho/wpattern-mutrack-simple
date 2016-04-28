using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using MutrackSimple.Models;

namespace MutrackSimple.Controllers
{
    public class PackageController : ApiController
    {
        private MutrackSimpleEntities db = new MutrackSimpleEntities();

        // GET: api/Package
        public IQueryable<PackageEntity> GetPackages()
        {
            return db.Packages;
        }

        // GET: api/Package/5
        [ResponseType(typeof(PackageEntity))]
        public IHttpActionResult GetPackageEntity(int id)
        {
            PackageEntity packageEntity = db.Packages.Find(id);
            if (packageEntity == null)
            {
                return NotFound();
            }

            return Ok(packageEntity);
        }

        // PUT: api/Package/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutPackageEntity(int id, PackageEntity packageEntity)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != packageEntity.Id)
            {
                return BadRequest();
            }

            db.Entry(packageEntity).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PackageEntityExists(id))
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
        public IHttpActionResult PostPackageEntity(PackageEntity packageEntity)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Packages.Add(packageEntity);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (PackageEntityExists(packageEntity.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = packageEntity.Id }, packageEntity);
        }

        // DELETE: api/Package/5
        [ResponseType(typeof(PackageEntity))]
        public IHttpActionResult DeletePackageEntity(int id)
        {
            PackageEntity packageEntity = db.Packages.Find(id);
            if (packageEntity == null)
            {
                return NotFound();
            }

            db.Packages.Remove(packageEntity);
            db.SaveChanges();

            return Ok(packageEntity);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PackageEntityExists(int id)
        {
            return db.Packages.Count(e => e.Id == id) > 0;
        }
    }
}