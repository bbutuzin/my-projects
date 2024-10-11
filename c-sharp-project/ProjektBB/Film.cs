using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjektBB {
    public class Film {
        public Film() {

        }
        public Film(object zanr) {
            Zanr = (string)zanr;
        }
        public Film(string zanr) {
            Zanr = zanr;
        }
        public Film(object id, object naziv, object trajanje, object godina, object zanr) {
            Id = (int)id;
            Naziv = (string)naziv;
            Trajanje = (int)trajanje;
            Godina = (int)godina;
            Zanr = (string)zanr;

        }
        public Film(string naziv, int trajanje, int godina, string zanr) {
            Naziv = naziv;
            Trajanje = trajanje;
            Godina = godina;
            Zanr = zanr;

        }
        public override string ToString() {
            return Naziv;
        }
        public int Id { get; set; }
        public string Naziv { get; set; }
        public int Trajanje { get; set; }
        public int Godina { get; set; }
        public string Zanr { get; set; }

    }
}
