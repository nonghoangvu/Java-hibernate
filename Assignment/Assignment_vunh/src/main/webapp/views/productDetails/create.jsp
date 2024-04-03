<div class="forms-container py-2 bg-white rounded shadow">
    <div class="row">
        <div class="col-5 panel right-panel text-center px-5 py-5">
            <img src="/assets/img/undraw_add_user_re_5oib.svg" class="image" alt="" style="width: 20em"/>
        </div>
        <div class="col">
            <form action="/product-detail/store" method="post" class="form-floating px-5 py-5">
                <h2 class="fw-bold text-center mb-5">Add New Product Detail</h2>
                <div class="row">
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="tenMau" name="tenMau">
                            <label for="tenMau">Enter a product-detail name</label>
                        </div>
                    </div>
                    <div class="col-12 mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="Active" id="trangThai"
                                   name="trangThai">
                            <label class="form-check-label" for="trangThai">
                                Active
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <a href="/product-detail/index" class="btn btn-outline-danger">Cancel</a>
                        <button type="submit" class="btn btn-outline-info">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>