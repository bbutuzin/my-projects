using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjektBB {
    class Baza {
        public static string ConnectionString() {
            return string.Format(
                "Data Source = {0}; Initial Catalog = {1}; User ID = {2}; Password = {3}",
                host,
                database,
                username,
                password
            );
        }

        private const string host = "sql.vub.zone,14330";
        private const string database = "bbutuzin-projekt";
        private const string username = "sa";
        private const string password = "VUBserver2020";
    }

}

