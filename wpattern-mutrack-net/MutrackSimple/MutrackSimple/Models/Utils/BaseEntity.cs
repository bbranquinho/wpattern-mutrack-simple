using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Web;

namespace MutrackSimple.Models.Utils
{
    public abstract class BaseEntity<PK>
    {
        public PK Pk { get; set; }

        public override string ToString()
        {
            var sb = new StringBuilder();

            var clazz = this.GetType();
            sb.Append("[");

            FieldInfo[] fields = clazz.GetFields(BindingFlags.Instance | BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.GetField);

            for (int i = 0; i < fields.Length; i++)
            {
                FieldInfo field = fields[i];
                if (!field.IsStatic)
                {
                    sb.AppendFormat("{0}={1}\n", field.Name, field.GetValue(this) ?? "null");
                }
            }

            sb.Append("]");
            return sb.ToString();
        }

        public virtual bool Validate()
        {
            return true;
        }
    }
}