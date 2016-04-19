using MutrackSimple.Models.Utils;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MutrackSimple.Models.Repositories.Impl
{
    public class PackageRepositoryImpl : GenericRepositoryImpl<PackageEntity, int>, PackageRepository
    {
        public PackageRepositoryImpl(DbContext context) : base(context)
        {
        }
    }
}