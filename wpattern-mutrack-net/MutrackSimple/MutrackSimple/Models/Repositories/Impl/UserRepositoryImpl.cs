using MutrackSimple.Models.Utils;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MutrackSimple.Models.Repositories.Impl
{
    public class UserRepositoryImpl : GenericRepositoryImpl<UserEntity, int>, UserRepository
    {
        public UserRepositoryImpl(DbContext context) : base(context)
        {
        }
    }
}