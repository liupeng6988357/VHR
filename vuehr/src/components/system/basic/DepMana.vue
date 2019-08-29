<template>
  <div>
    <div>

    </div>
    <div>
      <el-tree :data="deps"
               :props="defaultProps"
               :render-content="renderContent"
               @node-click="handleNodeClick"
               style="font-family: '等线 Light'; font-size: 10px; color: black; width: 550px; line-height: 55px;"></el-tree>
    </div>
  </div>
</template>
<script>
  export default {
      name:"DepMana",

      data() {
          return {
              deps: [],
              defaultProps: {
                  children: 'children',
                  label: 'name'
              }
          };
      },

      mounted() {
          this.initDeps();
      },

      methods: {
          initDeps(){
              this.getRequest("/system/basic/dep/").then(data => {
                  if (data) {
                      this.deps = data.data;
                  }
              })
          },
          renderContent(h, { node, data, store }) {
              return (
                  <span class="custom-tree-node" style = "display:flex; justify-content:space-between; width:100%">
                  <span>{node.label}</span>
                  <span>
                  <el-button style="margin:2px; padding:3px; font-size:5px; width:80px;"  size="medium" type="text" on-click={ () => this.append(data) } round>编辑部门</el-button>
                  <el-button style="margin:2px; padding:3px; font-size:5px; width:80px; color:red;"  size="medium" type="text"  on-click={ () => this.remove(node, data) } round>删除部门</el-button>
              </span>
              </span>);
      }

      }
  };
</script>
