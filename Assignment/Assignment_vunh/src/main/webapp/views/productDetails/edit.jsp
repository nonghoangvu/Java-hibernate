<div class="forms-container py-2 bg-white rounded shadow">
    <div class="row">
        <div class="col-5 panel right-panel text-center px-5 py-5">
            <img src="/assets/img/undraw_cloud_files_wmo8.svg" class="image" alt="" style="width: 20em"/>
        </div>
        <div class="col">
            <form action="/product-detail/update?id=${prd.id}" id="updateProductDetailPost" method="post" class="form-floating px-5 py-5">
                <h2 class="fw-bold text-center mb-5">Edit Product Details</h2>
                <div class="row">
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="giaBan" name="giaBan"
                                   value="${prd.giaBan}">
                            <label for="giaBan">Enter price here</label>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="soLuongTon" name="soLuongTon"
                                   value="${prd.soLuongTon}">
                            <label for="soLuongTon">Enter quantity here</label>
                        </div>
                    </div>
                    <div class="col-12 mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="trangThai"
                                   name="trangThai" ${prd.trangThai.contains("Activity") ? "checked" : ""} >
                            <label class="form-check-label" for="trangThai">
                                Activity
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <a href="/product-detail/index?id=${prd.sanPham.id}" class="btn btn-danger">Cancel</a>
                        <button type="button" onclick="updateProductDetailValidate('updateProductDetailPost')" class="btn btn-light">Update</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>