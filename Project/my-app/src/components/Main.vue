<template>
  <v-container>
    <v-row justify="center">
      <v-btn @click="GoDelivery"><v-icon>mdi-home</v-icon></v-btn>
      <v-btn @click="GoTT">test</v-btn>
    </v-row>
         
  </v-container>
</template>

<script>

export default {
    data(){
        return{
          
    }
  },
   methods: {
      GoDelivery() {
          this.$router.push("/delivery");
          this.submitted = true;
      },
      GoTT() {
          this.$router.push("/ttt");
          this.submitted = true;
      }
    }
};
</script>