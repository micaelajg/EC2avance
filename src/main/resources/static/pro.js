$(document).ready(function (){
  listar();
});
function listar(){
   $.ajax({
        url: "/proveedor/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idproveedor + "</td><td>" + x[i].nombre
                        + "</td><td>" + x[i].telefono + "</td><td>" + x[i].direccion + "</td><td><a href='#' onclick='editar("
                        + x[i].idproveedor + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idproveedor + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    }); 
    
}
function editar(id) {
    $.ajax({
        url: "/proveedor/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombre").val(w.nombre);
            $("#editar_telefono").val(w.telefono);
            $("#editar_direccion").val(w.direccion);
            $("#idproveedor").val(w.idproveedor);
        }
    });
    $("#modalEditar").modal('show');
}
function eliminar(id) {
    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/proveedor/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}
$("#guardar").click(function () {
    var nombre = $("#nombre").val();
    var telefono = $("#telefono").val();
    var direccion = $("#direccion").val();
    $.ajax({
        url: "/proveedor/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'nombre': nombre, 'telefono': telefono, 'direccion': direccion}),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            limpiar();
            listar();
        }
    });
    $("#modalGuardar").modal('hide');
});
function limpiar() {
    $("#nombre").val("");
    $("#telefono").val("");
    $("#direccion").val("");
}
$("#modificar").click(function () {
    var nombre = $("#editar_nombre").val();
    var telefono = $("#editar_telefono").val();
    var direccion = $("#editar_direccion").val();
    var id = $("#idproveedor").val();
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/proveedor/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idproveedor': id, 'nombre': nombre, 'telefono': telefono, 'direccion': direccion}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        limpiar();
                        listar();
                    }
                });
                $("#modalEditar").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});
