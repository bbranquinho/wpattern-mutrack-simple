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
using MutrackSimple.Controllers.Utils;

namespace MutrackSimple.Controllers
{
    //[EnableCors(origins: "*", headers: "*", methods: "*")]
    public class PackageeController : GenericControllerImpl<PackageEntity, int>
    {
        #region Constructors
        public PackageeController() : base(new PackageeRepositoryImpl(new MutrackSimpleEntities()))
        {
        }
        #endregion
    }
}