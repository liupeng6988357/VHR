<template>
  <div>

    <div style="display: flex;justify-content: flex-end; align-items: end ">
      <div>
        <el-button style="width: 120px; font-family: '等线 Light'; " type="primary" @click="dialogVisible = true" plain >
          <i  style="color: azure" class="el-icon-plus"></i>
          新增职称
        </el-button>
        <el-button style="width: 120px; font-family: '等线 Light'; " type="primary"  @click="dialogVisible = true"  plain>
          <i  style="color: azure" class="el-icon-close"></i>
          删除职称
        </el-button>
        <el-button style="width: 120px; font-family: '等线 Light'; " type="primary"  @click="dialogVisible = true" plain>
          <i  style="color: azure" class="el-icon-check"></i>
          修改职称
        </el-button>

        <el-dialog
          title="新增职称"
          :visible.sync="dialogVisible"
          width="450px"
        style="margin-top: 150px;">
          <span style=" font-family: '微软雅黑 Light'; font-size: 15px">职称名称</span>
          <span>
            <el-input
              placeholder="请输入职称名称"
              v-model="input"
              size="mini"
              style="width: 120px;"
            >
            </el-input>
            <span style=" font-family: '微软雅黑 Light'; font-size: 15px">职称级别</span>
            <el-select v-model="value" placeholder="请选择职称级别" size="mini" style="width: 120px; font-family: '微软雅黑 Light';font-size: 10px">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          </span>
          <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
        </el-dialog>

      </div>
    </div>
    <div>
      <el-table
        ref="multipleTable"
        :data="jls"
        stripe
        :default-sort = "{prop: 'date', order: 'descending'}"
        tooltip-effect="dark"
        @selection-change="handleSelectionChange"
        style="width: 100%; font-family: '等线 Light';font-size: 10px; margin-top: 20px; color: black;"
        cellspacing="0" cellpadding="0" border="0" >
        <el-table-column
        type="selection"
        width="55">
        </el-table-column>
        <el-table-column
          sortable
          prop="id"
          label="编号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="name"
          label="职称名称"
          width="180">
        </el-table-column>
        <el-table-column
          prop="titlelevel"
          label="职称级别">
        </el-table-column>
        <el-table-column
          sortable
          prop="createdate"
          label="创建时间">
        </el-table-column>
        <el-table-column
          prop="enabled"
          label="是否可用">
          <template slot-scope="scope">
              <el-tag type="success" v-if="scope.row.enabled">是</el-tag>
              <el-tag type="primary" v-else>否</el-tag>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
    export default {
        name:"JobLevel",

        data(){
          return{
              jl:{
                  name:""
              },
              jls:[],
              multipleSelection: [],
              dialogVisible: false,
              options: [{
                  value: '选项1',
                  label: '黄金糕'
              }, {
                  value: '选项2',
                  label: '双皮奶'
              }, {
                  value: '选项3',
                  label: '蚵仔煎'
              }, {
                  value: '选项4',
                  label: '龙须面'
              }, {
                  value: '选项5',
                  label: '北京烤鸭'
              }]
          }

        },

        mounted(){
          this.initJls();
        },

        methods:{
            initJls(){
                this.getRequest("/system/basic/jobLevel/").then(data=>{
                    if (data){
                        this.jls = data.data;
                    }
                })
            },

            handleSelectionChange(val) {
                this.multipleSelection = val;
            }
        }
    }
</script>
