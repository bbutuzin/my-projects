using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;


namespace ProjektBB {
    class Filmovi {
        // void PokreniDohvacanjeFilmova() -> (new Thread(DohvatiFilmove))
        // void DohvatiFilmove() -> 
        // list 
        // public static void GetFilmovi()
        public static List<Film> GetFilmovi() {
            List<Film> filmovi = new List<Film>();
            string query = "SELECT * FROM Film ORDER BY Naziv";

                using (SqlConnection sqlConnection = new SqlConnection(Baza.ConnectionString())) {
                    SqlDataAdapter adapter = new SqlDataAdapter(query, sqlConnection);
                    DataSet ds = new DataSet();
                    adapter.Fill(ds);
                    foreach (DataRow redak in ds.Tables[0].Rows) {
                        filmovi.Add(new Film(
                            redak["Id"],
                            redak["Naziv"],
                            redak["Trajanje"],
                            redak["Godina"],
                            redak["Zanr"]
                            ));
                    }
                    return filmovi;
    }
           
            
            
        }

        public static List<Film> IznenadiMe() {
            List<Film> filmovi = new List<Film>();
            string query = "SELECT * FROM Film ORDER BY NEWID()";

            using (SqlConnection sqlConnection = new SqlConnection(Baza.ConnectionString())) {
                SqlDataAdapter adapter = new SqlDataAdapter(query, sqlConnection);
                DataSet ds = new DataSet();
                adapter.Fill(ds);
                foreach (DataRow redak in ds.Tables[0].Rows) {
                    filmovi.Add(new Film(
                        redak["Id"],
                        redak["Naziv"],
                        redak["Trajanje"],
                        redak["Godina"],
                        redak["Zanr"]
                    ));
                }
            }
            return filmovi;
        }


    }
}
