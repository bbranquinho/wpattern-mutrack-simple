using MutrackSimple.Models.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MutrackSimple.Controllers.Utils
{
    public interface GenericController<T, PK> where T : BaseEntity<PK>
    {
        // GET: api/T
        IQueryable<T> Get();
    }
}
