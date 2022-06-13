/* global bootbox */

$(document).ready(function (){
  listar();
});
function listar(){
   $.ajax({
        url: "/producto/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idproducto + "</td><td>" + x[i].idproveedor
                        + "</td><td>" + x[i].descripcion+ "</td><td>" + x[i].preciocosto+ "</td><td>" + x[i].precioventa  + "</td><td><a href='#' onclick='editar("
                        + x[i].idproducto+ ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idproducto + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    }); 
    
}
function editar(id) {
    $.ajax({
        url: "/producto/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_descripcion").val(w.descripcion);
            $("#editar_preciocosto").val(w.preciocosto);
            $("#editar_precioventa").val(w.precioventa);
            $("#idproducto").val(w.idproducto);
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
                    url: "/producto/" + id,
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
    var descripcion = $("#descripcion").val();
    var preciocosto = $("#preciocosto").val();
    var precioventa = $("#precioventa").val();
    var cod = document.getElementById("proveedor").value;
    $.ajax({
        url: "/producto/add",
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'idproveedor':cod,'descripcion':descripcion, 'preciocosto': preciocosto, 'precioventa': precioventa}),
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
    $("#descripcion").val("");
    $("#preciocosto").val("");
    $("#precioventa").val("");
 
}
$("#modificar").click(function () {
    var descripcion = $("#editar_descripcion").val();
    var preciocosto= $("#editar_preciocosto").val();
    var precioventa = $("#editar_precioventa").val();
    var id = $("#idproducto").val();
  
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
                    url: "/producto/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idproducto': id ,'descripcion': descripcion, 'preciocosto': preciocosto, 'precioventa': precioventa}),
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

