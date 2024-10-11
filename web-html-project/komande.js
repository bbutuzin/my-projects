projekt = "p_pmisir";
url = "https://dev.vub.zone/sandbox/router.php";

$.ajaxSetup({
    xhrFields: {
        withCredentials: true
    }
});

$(document).ready(function () {
    refresh();
});

//buttoni
$(document).on('click', '#LogginButton', function () {
    var email = $('#inputEmail').val();
    var password = $('#inputPassword').val();
    if (email == null || email == "") {
        Swal.fire('Molimo unesite email adresu');
        console.log("emal");
    } else if (password == null || password == "") {
        Swal.fire('Molimo unesite zaporku');
        console.log("zaporka");
    } else {
        login();
    }
})

$(document).on('click', '#LoggoutButton', function () {
    logout();
})

$(document).on('click', '#PodaciButton', function () {
    showPodaci();
})

$(document).on('click', '#UnosPodaciButton', function () {
    insertFormPodaci();
})

$(document).on('click', '#PocetnaButton', function () {
    pocetna();
})

function login() {
    $.ajax({
        type: 'POST',
        url: url,
        data: {"projekt": projekt, "procedura": "p_login", "username": $('#inputEmail').val(), "password": $('#inputPassword').val()},
        success: function (data) {
            console.log(data+"s");
            var jsonBody = JSON.parse(data);
            var errcod = jsonBody.h_errcod;
            var message = jsonBody.h_message;

            if (message == null || message == "", errcod == null || errcod == 0) {
                refresh();                
            } else {
                Swal.fire(message + '.' + errcod);
            }
        },
        error: function (xhr, textStatus, error) {
            console.log(xhr.statusText);
            console.log(textStatus);
            console.log(error);
        },
        async: true
    });
}


function logout() {
    $.ajax({
        type: 'POST',
        url: url,
        data: { "projekt": "p_common", 
                "procedura": "p_logout" 
            },
        success: function (data) {
            var jsonBody = JSON.parse(data);
            var errcode = jsonBody.h_errcode;
            var message = jsonBody.h_message;
            if (message == null || message == "" || errcode == null) {
                Swal.fire("Greška u obradi podataka, molimo pokušajte ponovno!");
            } else {
                Swal.fire(message + '.' + errcode);
            }
            refresh();
        },
        error: function (xhr, textStatus, error) {
            console.log(xhr.statusText);
            console.log(textStatus);
            console.log(error);
        },
        async: true
    });
}


function refresh() {
    var url = "https://dev.vub.zone/sandbox/router.php"
    $.ajax({
        type: 'POST',
        url: url,
        data: { "projekt": "p_common", "procedura": "p_refresh" },
        success: function (data) {
            var jsonBody = JSON.parse(data);
            console.log(jsonBody);
            var podaci;
            if (jsonBody.h_errcode !== 999){
                podaci = '<b style="color:white">'+jsonBody.ime + ' ' + jsonBody.prezime  + ' <b><button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="LoggoutButton">log out</button>' ;
            } else{
                podaci = '<form class="form-inline my-2 my-lg-0"><input class="form-control mr-sm-2"  id="inputEmail" placeholder="Korisničko ime:" aria-label="Username"><input class="form-control mr-sm-2" id="inputPassword" placeholder="Lozinka:" aria-label="Password"><button class="btn btn-outline-success my-2 my-sm-0" type="button" id="LogginButton">log in </button></form>';
            }
            $("#podaci").html(podaci);
        },
        error: function (xhr, textStatus, error) {
            console.log(xhr.statusText);
            console.log(textStatus);
            console.log(error);
        },
        async: true
    });	
}

function pocetna() {
    var output = '<div class="album py-5 bg-light">';
    output += '<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">';  
    output += '<div class="col">';
    output += '    <div class="card shadow-sm">';
    output += '      <img src="fajlovi/zagreb.jpg" width="100%" height="225px">';
    output += '      <div class="card-body">';
    output += '       <p class="card-text"><b>Zagereb</b> - možete pročitati općenite informacije o gradu na sljedećem <a href="https://hr.wikipedia.org/wiki/Zagreb" target="_blank">link-u</a></p>';
    output += '      </div>';
    output += '    </div>';
    output += '  </div>';
    output += '  <div class="col">';
    output += '    <div class="card shadow-sm">';
    output += '     <img src="fajlovi/split.jpg" width="100%" height="225px">';
    output += '      <div class="card-body">';
    output += '        <p class="card-text"><b>Split</b> - možete pročitati općenite informacije o gradu na sljedećem <a href="https://hr.wikipedia.org/wiki/Split" target="_blank">link-u</a></p>';
    output += '      </div>';
    output += '    </div>';
    output += '  </div>';
    output += ' <div class="col">';
    output += '   <div class="card shadow-sm">';
    output += '     <img src="fajlovi/zadar.jpg" width="100%" height="225px">';
    output += '     <div class="card-body">';
    output += '       <p class="card-text"><b>Zadar</b> - možete pročitati općenite informacije o gradu na sljedećem <a href="https://hr.wikipedia.org/wiki/Zadar" target="_blank">link-u</a></p>';
    output += '    </div>';
    output += '   </div>';
    output += ' </div>';
    output += '</div>';
    output += ' <div class="row" style="margin-top: 3%; padding: 0;">';
    output += ' <div class="col">';
    output += '   <div class="card shadow-sm" style="width: 65%; margin-right: 3%; float: right;">';
    output += '     <img src="fajlovi/slavonski_brod.jpg" width="100%" height="225px">';
    output += '     <div class="card-body">';
    output += '      <p class="card-text"><b>Slavonski Brod</b> - možete pročitati općenite informacije o gradu na sljedećem <a href="https://hr.wikipedia.org/wiki/Slavonski_Brod" target="_blank">link-u</a></p>';
    output += '    </div>';
    output += '  </div>';
    output += ' </div>';
    output += '<div class="col">';
    output += '   <div class="card shadow-sm" style="width: 65%; margin-left: 3%">';
    output += '      <img src="fajlovi/osijek.jpg" width="100%" height="225px">';
    output += '     <div class="card-body">';
    output += '       <p class="card-text"><b>Osijek</b> - možete pročitati općenite informacije o gradu na sljedećem <a href="https://hr.wikipedia.org/wiki/Osijek" target="_blank">link-u</a></p>';
    output += '    </div>';
    output += '  </div>';
    output += ' </div>';
    output += ' </div>';
    output += '</div>';
    $("#container").html(output);
}

//prikaz podataka
function showPodaci(){
    tablica = '<table class="table table-bordered"><thead><tr><th>Godina</th><th>Naziv</th><th>Broj privatnih registriranih automobila</th><th>Broj nasilnih Smrti</th><th>Broj nocenja</th></tr></thead><tbody>';
    $.ajax({
        type: 'POST',
        url: url,
        data: {
            "projekt": projekt, 
            "procedura": "p_printpodaci", 
        },
        success: function (data) {
            var jsonBody = JSON.parse(data);
            var errcode = jsonBody.h_errcode;
            var message = jsonBody.h_message;

            if (message == null || message == "", errcode == null || errcode == 0) {
                $.each(jsonBody.data, function (k, v) {
                    tablica += '<tr><td>' + v.GODINA + '</td>';
                    tablica += '<td>' + v.NAZIV + '</td>';
                    tablica += '<td>' + v.BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA + '</td>';
                    tablica += '<td>' + v.BROJNASILNIHSMRTI + '</td>';
                    tablica += '<td>' + v.BROJNOCENJA + '</td>';
                    tablica += '<td><button type="button" class="btn btn-primary" onclick="showPodatak(' + v.ID + ')">Edit <i class="fas fa-edit"></i></button> ';
                    tablica += '<button type="button" class="btn btn-danger" onclick="deletePodatak(' + v.ID + ')">Delete <i class="far fa-trash-alt"></i></button></td></tr>';
                });
                tablica += '</tbody></table>';
                tablica += '<a href="#" id="UnosPodaciButton">Unesi podatak</a>';
                $("#container").html(tablica);
            } else {
                Swal.fire(message + '.' + errcode);
            }
            refresh();
        },
        error: function (xhr, textStatus, error) {
            console.log(xhr.statusText);
            console.log(textStatus);
            console.log(error);
        },
        async: true
    });
}

//forma za unos podatka
function insertFormPodaci() {
    var output = '<table class="table table-hover"><tbody>';
    output += '<tr><th scope="col">ID godine</th><td><input type="text" id="IDGODINE"></td></tr>';
    output += '<tr><th scope="col">ID grada</th><td><input type="text" id="IDGRADA"></td></tr>';
    output += '<tr><th scope="col">Broj privatnih registriranih automobila</th><td><input type="tex" id="BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA"></td></tr>';
    output += '<tr><th scope="col">Broj nasilnih smrti</th><td><input type="text" id="BROJNASILNIHSMRTI"></td></tr>';
    output += '<tr><th scope="col">Broj nocenja</th><td><input type="text" id="BROJNOCENJA"></td></tr>';
    output += '</table>';
    output += '<button type="button" class="btn btn-warning" id="spremiPodaci">Spremi <i class="fas fa-save"></i></button> ';
    output += '<button type="button" class="btn btn-success" onclick="showPodaci()">Odustani <i class="fas fa-window-close"></i></button><br><br>';
    $("#container").html(output);
}


//prikaz jednog podatka
function showPodatak(ID) {
    var tablica = '<table class="table table-hover"><tbody>';
    $.ajax({
        type: 'POST',
        url: url,
        data: { "projekt": projekt, "procedura": "p_printpodaci", "ID": ID },
        success: function (data) {
            var jsonBody = JSON.parse(data);
            var errcode = jsonBody.h_errcode;
            var message = jsonBody.h_message;

            if (message == null || message == "", errcode == null || errcode == 0) {
                $.each(jsonBody.data, function (k, v) {
                    tablica += '<tr><th scope="col">ID</th><td><input type="text" id="ID" value="' + v.ID + '" readonly></td></tr>';
                    tablica += '<tr><th scope="col">ID godine</th><td><input type="text" id="IDGODINE" value="' + v.IDGODINE + '"></td></tr>';
                    tablica += '<tr><th scope="col">ID grada</th><td><input type="text" id="IDGRADA" value="' + v.IDGRADA + '"></td></tr>';
                    tablica += '<tr><th scope="col">Broj privatnih registriranih automobila</th><td><input type="text" id="BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA" value="' + v.BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA + '"></td></tr>';
                    tablica += '<tr><th scope="col">Broj nasilnih smrti</th><td><input type="text" id="BROJNASILNIHSMRTI" value="' + v.BROJNASILNIHSMRTI + '"></td></tr>';
                    tablica += '<tr><th scope="col">Broj nocenja</th><td><input type="text" id="BROJNOCENJA" value="' + v.BROJNOCENJA + '"></td></tr>';
                    tablica += '</table>';
                    tablica += '<button type="button" class="btn btn-warning" id="spremiPodaci">Spremi <i class="fas fa-save"></i></button> ';
                    tablica += '<button type="button" class="btn btn-success" onclick="showPodaci()">Odustani <i class="fas fa-window-close"></i></button><br><br>';
                });
                $("#container").html(tablica);
            } else {
                Swal.fire(message + '.' + errcode);
            }
            refresh();
        },
        error: function (xhr, textStatus, error) {
            console.log(xhr.statusText);
            console.log(textStatus);
            console.log(error);
        },
        async: true
    });
}

//spremi u bazu
$(document).on('click', '#spremiPodaci', function () {
    var IDGODINE = $('#IDGODINE').val();
    var IDGRADA = $('#IDGRADA').val();
    var BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA = $('#BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA').val();
    var BROJNASILNIHSMRTI = $('#BROJNASILNIHSMRTI').val();
    var BROJNOCENJA = $('#BROJNOCENJA').val();
    var ID = $('#ID').val();

    if (IDGODINE == null || IDGODINE == "") {
        Swal.fire('Molimo unesite id godine');
    } else if (IDGRADA == null || IDGRADA == "") {
        Swal.fire('Molimo unesite id grada');
    } else if (BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA == null || BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA == "") {
        Swal.fire('Molimo unesite broj privatnih registriranih automobila');
    } else if (BROJNASILNIHSMRTI == null || BROJNASILNIHSMRTI == "") {
        Swal.fire('Molimo unesite broj nasilnih smrti');
    } else if (BROJNOCENJA == null || BROJNOCENJA == "") {
        Swal.fire('Molimo unesite broj noćenja');
    } else {
        $.ajax({
            type: 'POST',
            url: url,
            data: {
                "projekt": projekt,
                "procedura": "p_insertpodaci",
                "ID": ID,
                "IDGODINE": IDGODINE,
                "IDGRADA": IDGRADA,
                "BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA": BROJPRIVATNIHREGISTRIRANIHAUTOMOBILA,
                "BROJNASILNIHSMRTI": BROJNASILNIHSMRTI,
                "BROJNOCENJA": BROJNOCENJA
            },
            success: function (data) {
                var jsonBody = JSON.parse(data);
                var errcode = jsonBody.h_errcode;
                var message = jsonBody.h_message;
                console.log(data);

                if ((message == null || message == "") && (errcode == null || errcode == 0)) {
                    Swal.fire('Uspješno se unijeli podatke');
                    showPodaci();
                    refresh();
                } else {
                    Swal.fire(message + '.' + errcode);
                    showPodaci();
                }                
            },
            error: function (xhr, textStatus, error) {
                console.log(xhr.statusText);
                console.log(textStatus);
                console.log(error);
            },
            async: true
        });
    }
})

//delete podatka
function deletePodatak(ID){
    Swal.fire({
        title: 'Želite li zaista obrisati podatak?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Da, obriši podatak!',
        cancelButtonText: 'Ipak nemoj!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                type: 'POST',
                url: url,
                data: {
                    "projekt": projekt,
                    "procedura": "p_insertpodaci",
                    "ID": ID,
                    "ACTION": "delete"
                },
                success: function (data) {
                    var jsonBody = JSON.parse(data);
                    var errcode = jsonBody.h_errcode;
                    var message = jsonBody.h_message;
                    console.log(data);

                    if ((message == null || message == "") && (errcode == null || errcode == 0)) {
                        Swal.fire(
                            'Uspješno ',
                            'ste obrisali podatak',
                            'success'
                        );
                        refresh();
                        showPodaci();
                    } else {
                        Swal.fire(message + '.' + errcode);
                        showPodaci();
                    }                    
                },
                error: function (xhr, textStatus, error) {
                    console.log(xhr.statusText);
                    console.log(textStatus);
                    console.log(error);
                },
                async: true
            });
        }
    })
}
