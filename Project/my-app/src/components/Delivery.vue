<template>
    <v-container>
       
        <h1 class="blue darken-4 white--text text--darken-4 text-center">รถขนส่งพัสดุ</h1>
           
        <v-form v-model="valid" ref="form">
        <v-row>
          <v-row >
              <v-col cols="10">
                <v-select
                  label="Parcel"
                  v-model="delivery.parcelId"
                  :items="parcels"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                ></v-select>
              </v-col>
            </v-row>

          <v-row >
              <v-col cols="10">
                <v-select
                  label="Employee"
                  v-model="delivery.employeeId"
                  :items="employees"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                ></v-select>
              </v-col>
            </v-row>

             <v-row>
              <v-col cols="10">
                <v-select 
                  label="Warehouse"  
                  v-model="delivery.warehouseId"
                  :items="warehouses"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                ></v-select>
              </v-col>
            </v-row>

          </v-row>
            <v-btn @click="saveDelivery" :class="{ red: !valid, green: valid }">submit</v-btn>
      </v-form>
      <v-data-table
            :headers="headers"
            :items="items"
            class="elevation-1"
          >
          </v-data-table>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "delivery",
  data(){
    return{
      delivery: {
        warehouseId: "",
        employeeId: "",
        parcelId: ""
      },
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
      items: [],
      valid : false,
      warehouses : [],
      employees : [],
      parcels : []

    };
  },
  methods: {
    /* eslint-disable no-console */
    getWarehouses() {
      http
        .get("/warehouse")
        .then(response => {
          this.warehouses = response.data;
          console.log(response.data);
          
        })
        .catch(e => {
          console.log(e);
        });
    },
    getEmployees() {
      http
        .get("/employee")
        .then(response => {
          this.employees = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
     getParcels() {
      http
        .get("/parcel")
        .then(response => {
          this.parcels = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
     saveDelivery() {
      http
        .post(
          "/delivery/" +
            this.delivery.parcelId +
            "/"+
            this.delivery.employeeId +
            "/" +
            this.delivery.warehouseId,
          this.delivery
        )
        .then(response => {
          console.log(response);
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
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
      this.getWarehouses();
      this.getEmployees();
      this.getParcels();
      this.getDeliverys();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.getWarehouses();
    this.getEmployees();
    this.getParcels();
    this.getDeliverys();
  }
};

</script>
