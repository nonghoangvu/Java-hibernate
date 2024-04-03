<div class="forms-container py-2 bg-white rounded shadow">
    <div class="row">
        <div class="col-5 panel right-panel text-center px-5 py-5">
            <img src="/assets/img/undraw_server_push_re_303w.svg" class="image" alt="" style="width: 20em"/>
        </div>
        <div class="col">
            <form action="/category/update?id=${category.id}" id="editCategoryPost" method="post" class="form-floating px-5 py-5">
                <h2 class="fw-bold text-center mb-5">Edit Categories</h2>
                <div class="row">
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="maDanhMuc" name="maDanhMuc"
                                   value="${category.maDanhMuc}">
                            <label for="maDanhMuc">Enter the category code here</label>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="tenDanhMuc" name="tenDanhMuc"
                                   value="${category.tenDanhMuc}">
                            <label for="tenDanhMuc">Enter the category name here</label>
                        </div>
                    </div>
                    <div class="col-12 mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="trangThai"
                                   name="trangThai" ${category.trangThai.contains("Activity") ? "checked" : ""} >
                            <label class="form-check-label" for="trangThai">
                                Activity
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <a href="/category/index" class="btn btn-danger">Cancel</a>
                        <button onclick="saveOrUpdateCategoryValidate('editCategoryPost')" type="button" class="btn btn-success">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>