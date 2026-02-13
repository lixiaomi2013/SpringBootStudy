/**
 * 产品选择组件
 */

// 当前选择的字段名
var currentSelectField = '';

/**
 * 打开产品选择弹窗
 * @param {string} fieldName 字段名称
 */
function selectProduct(fieldName) {
    if (!fieldName) {
        console.error('fieldName 参数不能为空');
        return;
    }
    
    currentSelectField = fieldName;
    console.log('打开产品选择弹窗，字段名:', fieldName);
    
    $('#productSelectModal').modal('show');
    
    // 初始化或刷新表格
    if (!$('#productSelectTable').hasClass('bootstrap-table')) {
        initProductTable();
    } else {
        $('#productSelectTable').bootstrapTable('refresh');
    }
}

/**
 * 初始化产品表格
 */
function initProductTable() {
    try {
        $('#productSelectTable').bootstrapTable({
            url: ctx + 'mgmt/product/list',
            method: 'post',
            contentType: "application/x-www-form-urlencoded",
            striped: true,
            cache: false,
            pagination: true,
            sortable: false,
            sidePagination: "server",
            queryParams: function(params) {
                var formData = {
                    productName: $('#productSelectModal input[name="productName"]').val() || '',
                    productCode: $('#productSelectModal input[name="productCode"]').val() || ''
                };
                console.log('查询参数:', formData);
                return $.extend({}, params, formData);
            },
            pageNumber: 1,
            pageSize: 10,
            pageList: [10, 25, 50, 100],
            search: false,
            showRefresh: false,
            clickToSelect: true,
            height: 400,
            uniqueId: "id",
            columns: [{
                checkbox: false,
                visible: true
            }, {
                field: 'productCode',
                title: '产品编码',
                align: 'center'
            }, {
                field: 'productName',
                title: '产品名称',
                align: 'center'
            }, {
                field: 'specification',
                title: '规格型号',
                align: 'center'
            }, {
                field: 'unit',
                title: '单位',
                align: 'center'
            }, {
                field: 'price',
                title: '单价',
                align: 'center',
                formatter: function(value) {
                    return value ? '¥' + parseFloat(value).toFixed(2) : '¥0.00';
                }
            }]
        });
        
        // 设置单选模式
        $('#productSelectTable').on('check.bs.table', function(e, row) {
            var rows = $(this).bootstrapTable('getSelections');
            if (rows.length > 1) {
                $(this).bootstrapTable('uncheckAll');
                $(this).bootstrapTable('checkBy', {field: 'id', values: [row.id]});
            }
        });
        
        console.log('产品表格初始化完成');
    } catch (error) {
        console.error('初始化产品表格失败:', error);
    }
}

/**
 * 确认选择产品
 */
function confirmProductSelect() {
    if (!currentSelectField) {
        $.modal.alertWarning("未找到选择的字段");
        return;
    }
    
    var selections = $('#productSelectTable').bootstrapTable('getSelections');
    
    if (selections.length === 0) {
        $.modal.alertWarning("请选择一条数据");
        return;
    }
    
    if (selections.length > 1) {
        $.modal.alertWarning("只能选择一个产品");
        return;
    }
    
    var product = selections[0];
    console.log('选择的产品:', product);
    
    // 设置隐藏的产品ID
    $('#' + currentSelectField).val(product.id);
    // 设置显示的产品名称
    $('#' + currentSelectField + 'Name').val(product.productName);
    
    // 触发change事件
    $('#' + currentSelectField).trigger('change');
    
    // 关闭弹窗
    $('#productSelectModal').modal('hide');
}

/**
 * 清空产品选择
 * @param {string} fieldName 字段名称
 */
function clearProduct(fieldName) {
    if (!fieldName) {
        console.error('fieldName 参数不能为空');
        return;
    }
    
    $('#' + fieldName).val('');
    $('#' + fieldName + 'Name').val('');
    
    // 触发clear事件
    $('#' + fieldName).trigger('clear');
    
    console.log('已清空产品选择:', fieldName);
}

/**
 * 搜索产品
 */
function searchProduct() {
    $('#productSelectTable').bootstrapTable('refresh');
}

/**
 * 重置搜索
 */
function resetProductSearch() {
    $('#productSelectModal input[name="productName"]').val('');
    $('#productSelectModal input[name="productCode"]').val('');
    searchProduct();
}

// 弹窗显示/隐藏事件处理
$(function() {
    $('#productSelectModal').on('show.bs.modal', function() {
        console.log('产品选择弹窗打开');
        // 每次打开时清空之前的搜索条件
        $('#productSelectModal input[name="productName"]').val('');
        $('#productSelectModal input[name="productCode"]').val('');
    });
    
    $('#productSelectModal').on('hidden.bs.modal', function() {
        console.log('产品选择弹窗关闭');
        currentSelectField = '';
        // 清空表格选择
        $('#productSelectTable').bootstrapTable('uncheckAll');
    });
    
    // 页面加载完成后绑定事件
    $(document).ready(function() {
        // 使用事件委托绑定按钮点击事件
        $(document).on('click', '.btn-select-product', function() {
            var fieldName = $(this).data('field-name');
            if (fieldName) {
                selectProduct(fieldName);
            }
        });
        
        $(document).on('click', '.btn-clear-product', function() {
            var fieldName = $(this).data('field-name');
            if (fieldName) {
                clearProduct(fieldName);
            }
        });
    });
});