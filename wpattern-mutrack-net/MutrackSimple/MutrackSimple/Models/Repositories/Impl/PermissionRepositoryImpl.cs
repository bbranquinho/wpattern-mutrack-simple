using MutrackSimple.Models.Utils;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MutrackSimple.Models.Repositories.Impl
{
    public class PermissionRepositoryImpl : GenericRepositoryImpl<PermissionEntity, int>, PermissionRepository
    {
        public PermissionRepositoryImpl(DbContext context) : base(context)
        {
        }
    }
}