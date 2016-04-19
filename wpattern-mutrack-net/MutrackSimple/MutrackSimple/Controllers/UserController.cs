using MutrackSimple.Models;
using MutrackSimple.Models.Repositories;
using MutrackSimple.Models.Repositories.Impl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace MutrackSimple.Controllers
{
    public class UserController : ApiController
    {
        #region Properties
        private UserRepository Repository { get; set; }
        #endregion

        #region Constructors
        public UserController()
        {
            var context = new MutrackSimpleEntities();
            Repository = new UserRepositoryImpl(context);
        }
        #endregion

        #region Service Methods
        public List<UserEntity> Get()
        {
            return Repository.GetAll().ToList();
        }
        #endregion
    }
}
