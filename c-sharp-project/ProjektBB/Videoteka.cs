using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Text.RegularExpressions;
using System.Data.SqlClient;


namespace ProjektBB {
    public partial class Videoteka : Form {
        
        public Videoteka() {
            InitializeComponent();
           

        }

        private void Pretraga_Click(object sender, EventArgs e) {

        }

        private void label2_Click(object sender, EventArgs e) {

        }

        private  void Videoteka_Load(object sender, EventArgs e) {


        }





        private void btnFilter_Click(object sender, EventArgs e) {
            var iznenadi = Filmovi.IznenadiMe();
            foreach (var film in iznenadi) {
                lbAllMovies.Items.Clear();
                lbAllMovies.Items.Add(film);
            }


        }

        private void btnRent_Click(object sender, EventArgs e) {
            Korisnik korisnik = new Korisnik(lbAllMovies.Items);
            korisnik.Show();




        }


        private void button1_Click(object sender, EventArgs e) {
            PostaviFilmove();
        }

        private void btnTrace_Click(object sender, EventArgs e) {

        }

        private void btnRentOne_Click(object sender, EventArgs e) {
            var odabraniFilm = lbAllMovies.Items[lbAllMovies.SelectedIndex];
            Korisnik korisnik = new Korisnik((Film)odabraniFilm);
            korisnik.Show();
        }


        private void PostaviFilmove() {
            lbAllMovies.Items.Clear();
            var filmovi = Filmovi.GetFilmovi();
            foreach (var film in filmovi) {
                lbAllMovies.Items.Add(film);
            }
        }

        }


    }
    



