using MutrackSimple.Models.Utils;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MutrackSimple.Models.Repositories.Impl
{
    public class PackageeRepositoryImpl : GenericRepositoryImpl<PackageEntity, int>, PackageRepository
    {
        public PackageeRepositoryImpl(DbContext context) : base(context)
        {
        }
    }
}