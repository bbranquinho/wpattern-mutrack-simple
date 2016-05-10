using MutrackSimple.Controllers.Utils;
using MutrackSimple.Models;
using MutrackSimple.Models.Repositories;
using MutrackSimple.Models.Repositories.Impl;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace MutrackSimple.Controllers
{
    //[EnableCors(origins: "*", headers: "*", methods: "*")]
    public class UserController : GenericControllerImpl<UserEntity, int>
    {
        #region Constructors
        public UserController() : base(new UserRepositoryImpl(new MutrackSimpleEntities()))
        {
        }
        #endregion
    }
}
