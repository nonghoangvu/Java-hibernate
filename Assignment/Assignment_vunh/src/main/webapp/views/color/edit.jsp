<div class="forms-container py-2 bg-white rounded shadow">
    <div class="row">
        <div class="col-5 panel right-panel text-center px-5 py-5">
            <img src="/assets/img/undraw_cloud_files_wmo8.svg" class="image" alt="" style="width: 20em"/>
        </div>
        <div class="col">
            <form action="/color/update?id=${color.id}" id="editColorPost" method="post" class="form-floating px-5 py-5">
                <h2 class="fw-bold text-center mb-5">Update color</h2>
                <div class="row">
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="maMau" name="maMau"
                                   value="${color.maMau}">
                            <label for="maMau">Enter the color code</label>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="tenMau" name="tenMau"
                                   value="${color.tenMau}">
                            <label for="tenMau">Enter a color name</label>
                        </div>
                    </div>
                    <div class="col-12 mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="trangThai"
                                   name="trangThai" ${color.trangThai.contains("Activity") ? "checked" : ""} >
                            <label class="form-check-label" for="trangThai">
                                Activity
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <a href="/color/index" class="btn btn-danger">Cancel</a>
                        <button type="button" onclick="saveOrUpdateColorValidate('editColorPost')" class="btn btn-success">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>