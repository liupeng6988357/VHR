<template>
  <div>
    <el-container style="">
      <el-header style="background-color: dodgerblue; display: flex;justify-content: space-between;align-items: center" >
        <div style="font-size: 20px; line-height: 60px;font-family: '等线 Light'">
          企业微人事
        </div>

        <el-dropdown style="cursor: pointer" @command="menuCommand">
          <span class="el-dropdown-link" >
            {{user.name}}<i><img :src="user.iconCls"></i>
          </span>
                <el-dropdown-menu slot="dropdown" >
                  <el-dropdown-item command="usercenter">个人中心</el-dropdown-item>
                  <el-dropdown-item command="setting">设置</el-dropdown-item>
                  <el-dropdown-item command="logout" divided>注销</el-dropdown-item>
                </el-dropdown-menu>
        </el-dropdown>
      </el-header>

      <el-container>

        <el-menu @select="menuSelect">
          <el-submenu :index="index+''" v-for="(router,index) in routes" v-if="!router.hidden" :key="index">
            <template slot="title">
              <i  style="color: dodgerblue" class="fa fa-cog fa-spin"></i>
              <span>{{router.name}}</span>
            </template>
            <el-menu-item-group>
              <el-menu-item :index="child.path" v-for="(child,index) in router.children" :key="index">{{child.name}}</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
        <el-main>

          <el-breadcrumb separator-class="el-icon-arrow-right" v-if="this.$router.currentRoute.path!=='/home'">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>{{this.$router.currentRoute.name}}</el-breadcrumb-item>
          </el-breadcrumb>
          <div style="width: 100%;display: flex;justify-content: center;margin-top: 100px;font-size: 30px;
          font-family: '等线 Light'" v-if="this.$router.currentRoute.path==='/home'">
            欢迎来到企业微人事系统
          </div>

          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
    export default {
        name:"Home",
        data(){
            return {
              user: JSON.parse(window.sessionStorage.getItem("user"))
            }
        },
        computed:{
          routes(){
              return this.$store.state.routes;
          }
        },
        methods:{
            menuSelect(index,indexPath){
                this.$router.push(index);
            },
            menuCommand(cmd){
                if (cmd ==="logout"){
                    this.$confirm('此操作将注销登录, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        this.getRequest("/logout");
                        window.sessionStorage.removeItem("user");
                        this.$router.replace("/");

                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消注销'
                        });
                    });
                }
            }
        }
    }
</script>
