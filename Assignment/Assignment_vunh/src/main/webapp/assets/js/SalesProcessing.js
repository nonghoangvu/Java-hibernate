function createInvoices(size) {
    if (size >= 5) {
        swal("Warning!", "Please process the remaining invoices to continue!", "error");
        return false;
    } else {
        swal({
            title: "Success!",
            text: "Invoice successfully created",
            icon: "success",
        }).then((value) => {
            if (value) {
                this.window.location.href = "/sell/newInvoices";
            }
        });
    }
}

function backToSale(id, size) {
    swal({
        title: "Are you sure?",
        text: "Do you want back to sales?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((confirm) => {
            if (confirm) {
                if (size >= 5) {
                    swal("Warning!", "Please process the remaining invoices to continue!", "error");
                    return false;
                } else {
                    swal({
                        title: "Success!",
                        text: "Status changed to pending",
                        icon: "success",
                    }).then((value) => {
                        if (value) {
                            this.window.location.href = "/bill/update?id=" + id;
                        }
                    });
                }
            }
        });
}

function cancelInvoices() {
    let idInvoices = document.getElementById("idInvoices").value;
    if (idInvoices === '' || idInvoices === null) {
        swal("Warning!", "No invoices have been selected yet!", "error");
        return false;
    }
    swal({
        title: "Are you sure?",
        text: "Do you want to cancel this invoice?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((confirm) => {
            if (confirm) {
                swal({
                    title: "Success!",
                    text: "Invoice successfully canceled",
                    icon: "success",
                }).then((value) => {
                    if (value) {
                        this.window.location.href = "/sell/cancelInvoices?id=" + idInvoices;
                    }
                });

            }
        });
}

function pay() {
    let totalMoney = document.getElementById('totalMoney').value;
    let idInvoices = document.getElementById("idInvoices").value;
    if (idInvoices === '' || idInvoices === null) {
        swal("Warning!", "No invoices have been selected yet!", "error");
        return false;
    } else if (totalMoney <= 0) {
        swal("Warning!", "Cannot checkout because there are no products in the cart!", "error");
        return false;
    }

    swal({
        title: "Are you sure?",
        text: "Do you want to pay?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((confirm) => {
            if (confirm) {
                swal({
                    title: "Success!",
                    text: "Payment success",
                    icon: "success",
                }).then((value) => {
                    if (value) {
                        document.getElementById('pay').submit();
                    }
                });
            }
        });

}

function addToCart(id, quantity) {
    let idInvoices = document.getElementById("idInvoices").value;
    if (idInvoices === '' || idInvoices === null) {
        swal("Warning!", "No invoices have been selected yet!", "error");
        return false;
    } else {
        swal("Quantity to add?", {
            content: "input",
        })
            .then((quantityToAdd) => {
                if (quantityToAdd !== null) {
                    if (quantityToAdd > quantity || quantityToAdd <= 0) {
                        swal("Warning!", "Invalid quantity!", "error");
                        return false;
                    } else {
                        this.window.location.href = "/sell/addToCart?id_product=" + id + "&quantity=" + quantityToAdd + "&id_invoice=" + idInvoices;
                    }
                } else {
                    swal("Warning!", "Invalid quantity!", "error");
                    return false;
                }
            });
    }
}

function deleteProductInvoice(id) {
    swal({
        title: "Are you sure?",
        text: "This product will be removed from the cart!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((confirm) => {
            if (confirm) {
                this.window.location.href = "/sell/deleteProductInvoice?id=" + id;
            }
        });
}

function search() {
    document.getElementById("search").submit();
}

function searchCustomer() {
    let phone = document.getElementById("searchCustomer").value
    let idInvoices = document.getElementById("idInvoices").value;
    if (idInvoices === null || idInvoices === '') {
        swal("Warning!", "No invoices have been selected yet!", "error");
        return false;
    }
    swal({
        title: "Success!",
        text: "Customer successfully added",
        icon: "success",
    }).then((value) => {
        if (value) {
            this.window.location.href = "/sell/addCustomer?id_detail=" + idInvoices + "&searchCustomer=" + phone;
        }
    });
}

function createOrEditCustomer() {
    let hoTen = document.getElementById("hoTen").value;
    let diaChi = document.getElementById("diaChi").value;
    let sdt = document.getElementById("sdt").value;
    let idInvoices = document.getElementById("idInvoices").value;
    if (idInvoices === null || idInvoices === '') {
        swal("Warning!", "No invoices have been selected yet!", "error");
        return false;
    } else if (hoTen === null || hoTen === '' || diaChi === null || diaChi === '' || sdt === null || sdt === '') {
        swal("Warning!", "Please do not leave data blank!", "error");
        return false;
    } else if (hoTen.length < 5 || hoTen.length > 50) {
        swal("Warning!", "Invalid name!", "error");
        return false;
    } else if (diaChi.length < 5) {
        swal("Warning!", "Invalid address!", "error");
        return false;
    } else if (sdt.length < 10 || sdt.length > 13) {
        swal("Warning!", "Invalid number phone!", "error");
        return false;
    } else {
        swal({
            title: "Success!",
            text: "Information is updated. You can add customers using this phone number",
            icon: "success",
        }).then((value) => {
            if (value) {
                document.getElementById('createOrEditCustomer').submit();
            }
        });
    }
}