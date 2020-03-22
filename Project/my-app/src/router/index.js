import Vue from 'vue'
import Router from 'vue-router';

import Delivery from '../components/Delivery';
import Main from '../components/Main';
import TEST from '../components/TEST';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: Main
        },
        {
            path: '/delivery',
            component: Delivery
        },
        {
            path: '/ttt',
            component: TEST
        }
    ]
});