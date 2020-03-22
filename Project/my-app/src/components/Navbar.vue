<template>
   <nav>
     <v-app-bar app dark> <!--กำหนดสี Theme-->
      <v-toolbar-title class="headline text-uppercase">
        <span>Sut Express</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        text
        href="#"
        target="_blank"
      >
      <v-icon>mdi-home</v-icon>
        <span >หน้าแรก</span>
      </v-btn>
      <v-btn
        text
        href="#"
        target="_blank"
      >
        <span >ออกจากระบบ</span>
      </v-btn>
    </v-app-bar>
  </nav>
</template>

<script>
export default {
    
}
</script>