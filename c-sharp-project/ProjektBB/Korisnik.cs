using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjektBB {
    public partial class Korisnik : Form {

        public Korisnik(ListBox.ObjectCollection items) {
            InitializeComponent();
            lbMoviesRented.Items.AddRange(items);


        }

        public Korisnik(Film film) {
            InitializeComponent();
            lbMoviesRented.Items.Add(film);
        }

        private void textBox1_TextChanged(object sender, EventArgs e) {

        }

        private void Korisnik_Load(object sender, EventArgs e) {

        }

        private void btnPay_Click(object sender, EventArgs e) {
            if (cbPremium.Checked) {
                lblUser.Text = "Premium korisnik";
                lblUser.Refresh();
            } else {
                MessageBox.Show("Niste checkirali premium korisnik box!");
            }
        }

        private void btnReturn_Click(object sender, EventArgs e) {
            if (tbReturn.Text != "") {
                int i = 0;
                while (i <= lbMoviesRented.Items.Count) {
                    string Item_remove = tbReturn.Text;
                    if (lbMoviesRented.Items[i].ToString().Contains(Item_remove)) {
                        DialogResult conf_remove;
                        conf_remove = MessageBox.Show("Da li zelite vratiti film: " + lbMoviesRented.Items[i].ToString(), "Warning", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
                        if (conf_remove == DialogResult.Yes) {
                            lbMoviesRented.Items.RemoveAt(i);
                            break;
                        } else if (conf_remove == DialogResult.No)
                            i++;
                    } else {
                        MessageBox.Show("Nije nađen");
                        break;
                    }
                }

                tbReturn.Text = "";
                tbReturn.Focus();
            } else if (lbMoviesRented.SelectedIndex < 0)
                MessageBox.Show("Odaberite film za maknuti");
            else
                lbMoviesRented.Items.Remove(lbMoviesRented.SelectedItem);
        }
    }
}
