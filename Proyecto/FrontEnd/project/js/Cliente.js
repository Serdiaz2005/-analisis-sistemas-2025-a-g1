$(document).ready(function () {
    loadData();
});

// Cargar datos en la tabla
function loadData() {
    $.ajax({
        url: 'http://localhost:9000/api/cliente',
        method: 'GET',
        success: function (data) {
            let tableContent = '';
            data.forEach((item) => {
                tableContent += `
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.documento}</td>
                        <td>${item.nombre}</td>
                        <td>${item.apellido}</td>
                        <td>${item.email}</td>
                        <td>${item.telefono}</td>
                        <td>
                            <button class="btn btn-info btn-sm" onclick="editRecord(${item.id})">Editar</button>
                            <button class="btn btn-danger btn-sm" onclick="deleteRecord(${item.id})">Eliminar</button>
                        </td>
                    </tr>`;
            });
            $('#dataBody').html(tableContent);
        },
        error: function (error) {
            console.error('Error al cargar datos', error);
        }
    });
}

// Crear o actualizar un cliente
function createOrUpdate() {
    const id = $('#id').val();
    const data = {
        documento: $('#documento').val(),
        nombre: $('#nombre').val(),
        apellido: $('#apellido').val(),
        email: $('#correo').val(),
        telefono: $('#telefono').val()
    };

    const url = id ? `http://localhost:9000/api/cliente/${id}` : 'http://localhost:9000/api/cliente';
    const method = id ? 'PUT' : 'POST';

    $.ajax({
        url: url,
        method: method,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function () {
            resetForm();
            loadData();
            alert(id ? 'Cliente actualizado con éxito' : 'Cliente creado con éxito');
        },
        error: function (error) {
            console.error('Error al guardar datos', error);
        }
    });
}

// Editar registro
function editRecord(id) {
    $.ajax({
        url: `http://localhost:9000/api/cliente/${id}`,
        method: 'GET',
        success: function (data) {
            $('#id').val(data.id);
            $('#documento').val(data.documento);
            $('#nombre').val(data.nombre);
            $('#apellido').val(data.apellido);
            $('#correo').val(data.email);
            $('#telefono').val(data.telefono);
            $('#submitButton').text('Actualizar');
        },
        error: function (error) {
            console.error('Error al obtener el registro', error);
        }
    });
}

// Eliminar registro
function deleteRecord(id) {
    if (confirm('¿Estás seguro de eliminar este cliente?')) {
        $.ajax({
            url: `http://localhost:9000/api/cliente/${id}`,
            method: 'DELETE',
            success: function () {
                loadData();
                alert('Cliente eliminado con éxito');
            },
            error: function (error) {
                console.error('Error al eliminar cliente', error);
            }
        });
    }
}

// Limpiar formulario
function resetForm() {
    $('#id').val('');
    $('#documento').val('');
    $('#nombre').val('');
    $('#apellido').val('');
    $('#correo').val('');
    $('#telefono').val('');
    $('#submitButton').text('Guardar');
}
