<template>
  <div >
    <el-tabs v-model="activeName"  style="margin-top: 20px">
      <el-tab-pane label="部门管理" name="depMana"><DepMana></DepMana></el-tab-pane>
      <el-tab-pane label="职位管理" name="posMana"><PosMana></PosMana></el-tab-pane>
      <el-tab-pane label="职称管理" name="jobTitleMana"><JobTitleMana></JobTitleMana></el-tab-pane>
      <el-tab-pane label="奖惩规则" name="eCMana"><ECMana></ECMana></el-tab-pane>
      <el-tab-pane label="权限组" name="menuRole"><MenuRole></MenuRole></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>

  import MenuRole from './basic/MenuRole.vue'
  import DepMana from './basic/DepMana.vue'
  import ECMana from './basic/ECMana.vue'
  import JobTitleMana from './basic/JobTitleMana.vue'
  import PosMana from './basic/PosMana.vue'

  export default {
    data() {
      return {
          activeName: 'depMana'
        }
      },
      components:{
          MenuRole,
          DepMana,
          ECMana,
          JobTitleMana,
          PosMana
    }
  };
</script>
