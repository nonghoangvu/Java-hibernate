<div class="forms-container py-2 bg-white rounded shadow">
    <div class="row">
        <div class="col-5 panel right-panel text-center px-5 py-5">
            <img src="/assets/img/undraw_cloud_files_wmo8.svg" class="image" alt="" style="width: 20em"/>
        </div>
        <div class="col">
            <form action="/size/update?id=${size.id}" id="newSizePost" method="post" class="form-floating px-5 py-5">
                <h2 class="fw-bold text-center mb-5">Update Size</h2>
                <div class="row">
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="maSize" name="maSize"
                                   value="${size.maSize}">
                            <label for="maSize">Enter the size code</label>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="tenSize" name="tenSize"
                                   value="${size.tenSize}">
                            <label for="tenSize">Enter a size name</label>
                        </div>
                    </div>
                    <div class="col-12 mb-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="trangThai"
                                   name="trangThai" ${size.trangThai.contains("Activity") ? "checked" : ""} >
                            <label class="form-check-label" for="trangThai">
                                Activity
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <a href="/size/index" class="btn btn-danger">Cancel</a>
                        <button type="button" onclick="saveOrUpdateSizeValidate('newSizePost')" class="btn btn-success">Update</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>