<template>
  <v-data-table
    :headers="headers"
    :items="items"
    class="elevation-1"
  >
  </v-data-table>
</template>

<script>
import http from "../http-common";

  export default {
    data () {
      return {
        headers: [
          {
            text: 'Name',
            align: 'left',
            sortable: false,
            value: 'parcel.name',
          },
          { text: 'Employee', value: 'employee.name' },
          { text: 'Warehouse', value: 'warehouse.name' },
        ],
        items: []
      }
    },
     methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล VideoRental ใส่ combobox
    getDeliverys() {
      http
        .get("/delivery")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getDeliverys();
    }
    /* eslint-disable no-console */
  },
  mounted() {
    this.getDeliverys();
  }
  }
</script>