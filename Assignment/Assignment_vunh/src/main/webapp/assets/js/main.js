function saveProductDetailValidate(value) {
    let size = document.getElementById("size").value;
    let color = document.getElementById("mauSac").value;
    let price = document.getElementById("giaBan").value;
    let quantity = document.getElementById("soLuongTon").value;
    if (size === null || size === '' || color === null || color === '' || price === '' || quantity === '') {
        swal("Warning!", "Please fill in all fields!", "error");
        return false;
    } else if (price < 100 || price > 10000000) {
        swal("Warning!", "Invalid price!", "error");
        return false;
    } else if (quantity < 0 || quantity > 10000) {
        swal("Warning!", "Invalid quantity!", "error");
        return false;
    }
    swal({
        title: "Success!",
        text: "Changes save!",
        icon: "success",
    }).then((confirms) => {
        if (confirms) {
            document.getElementById(value).submit();
        }
    });
}

function updateProductDetailValidate(value) {
    let price = document.getElementById("giaBan").value;
    let quantity = document.getElementById("soLuongTon").value;
    if (price === '' || quantity === '') {
        swal("Warning!", "Please fill in all fields!", "error");
        return false;
    } else if (price < 100 || price > 10000000) {
        swal("Warning!", "Invalid price!", "error");
        return false;
    } else if (quantity < 0 || quantity > 10000) {
        swal("Warning!", "Invalid quantity!", "error");
        return false;
    }
    swal({
        title: "Success!",
        text: "Changes save!",
        icon: "success",
    }).then((confirms) => {
        if (confirms) {
            document.getElementById(value).submit();
        }
    });
}


function saveOrUpdateProductValidate(value) {
    let maSanPham = document.getElementById("maSanPham").value;
    let tenSanPham = document.getElementById("tenSanPham").value;
    let danhMuc = document.getElementById("danhMuc").value;
    if (maSanPham.trim() === '' || tenSanPham.trim() === '' || danhMuc === null || danhMuc === '') {
        swal("Warning!", "Please fill in all fields!", "error");
        return false;
    } else if (maSanPham.trim().length < 3 || maSanPham.trim().length >= 255) {
        swal("Warning!", "Invalid product code!", "error");
        return false;
    } else if (tenSanPham.trim().length < 5 || tenSanPham.trim().length >= 255) {
        swal("Warning!", "Invalid product name!", "error");
        return false;
    }
    swal({
        title: "Success!",
        text: "Changes save!",
        icon: "success",
    }).then((confirms) => {
        if (confirms) {
            document.getElementById(value).submit();
        }
    });
}

function saveOrUpdateCategoryValidate(value) {
    let maDanhMuc = document.getElementById("maDanhMuc").value;
    let tenDanhMuc = document.getElementById("tenDanhMuc").value;
    if (maDanhMuc.trim() === '' || tenDanhMuc.trim() === '') {
        swal("Warning!", "Please fill in all fields!", "error");
        return false;
    }
    swal({
        title: "Success!",
        text: "Changes save!",
        icon: "success",
    }).then((confirms) => {
        if (confirms) {
            document.getElementById(value).submit();
        }
    });
}

function saveOrUpdateColorValidate(value) {
    let maMau = document.getElementById("maMau").value;
    let tenMau = document.getElementById("tenMau").value;
    if (maMau.trim() === '' || tenMau.trim() === '') {
        swal("Warning!", "Please fill in all fields!", "error");
        return false;
    }
    swal({
        title: "Success!",
        text: "Changes save!",
        icon: "success",
    }).then((confirms) => {
        if (confirms) {
            document.getElementById(value).submit();
        }
    });
}

function saveOrUpdateSizeValidate(value) {
    let maSize = document.getElementById("maSize").value;
    let tenSize = document.getElementById("tenSize").value;
    if (maSize.trim() === '' || tenSize.trim() === '') {
        swal("Warning!", "Please fill in all fields!", "error");
        return false;
    }
    swal({
        title: "Success!",
        text: "Changes save!",
        icon: "success",
    }).then((confirms) => {
        if (confirms) {
            document.getElementById(value).submit();
        }
    });
}

function updateAccount() {
    let password = document.getElementById("password").value;
    if (password.trim() === '') {
        swal("Warning!", "Please enter password!", "error");
        return false;
    } else if (password.trim().length < 5 || password.trim().length > 20) {
        swal("Warning!", "Invalid password!", "error");
        return false;
    }
    swal({
        title: "Success!",
        text: "Update success password!",
        icon: "success",
    }).then((confirms) => {
        if (confirms) {
            document.getElementById('updateAccount').submit();
        }
    });
}