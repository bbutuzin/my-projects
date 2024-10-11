using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace ProjektBB {
    public partial class LOGIN : Form {
        public LOGIN() {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e) {

        }

        private void button1_Click(object sender, EventArgs e) {
            this.Close();
        }

        private void label5_Click(object sender, EventArgs e) {

        }

        private void label2_Click(object sender, EventArgs e) {

        }

        private void textBox2_TextChanged(object sender, EventArgs e) {

        }

        private void btnLogIn_Click(object sender, EventArgs e) {
            string username;
            string password;
            username = tbUserName.Text;
            password = tbPassword.Text;
            if (tbUserName.Text == "admin" && password == "admin") {
                this.Hide();
                Videoteka videoteka = new Videoteka();
                videoteka.Show();

            } else {
                MessageBox.Show("Krivo ste unijeli username ili lozinku.");
            }

        }
    }
}
