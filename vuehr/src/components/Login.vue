<template>
  <div style="display: flex;justify-content: center">
    <el-card class="box-card" style="width: 450px;margin-top: 150px; ">
      <div slot="header" class="cervix" >
        <span>微人事</span>
      </div>
      <div style="display: flex;justify-content: left">
        <el-form :model="user"  label-width="100px" class="demo-ruleForm">
          <el-form-item label="用户名">
            <el-input type="text" v-model="user.username" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input type="password" v-model="user.password" placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button  style="width: 130px; justify-content: center" type="primary" @click="doLogin">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>

  export default {
        name: "Login",
        data() {
            return {
                user: {
                    username: "",
                    password: ""
                }
            }
        },
        methods:{
            doLogin(){
                this.postRequest("/doLogin",this.user).then(massage=>{
                    if (massage){
                        window.sessionStorage.setItem("user",JSON.stringify(massage.data.obj));
                        this.$router.replace("home");
                    }
                })
            },
        }
    }
</script>

<style scoped>

</style>
