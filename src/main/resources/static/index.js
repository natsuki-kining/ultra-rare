Vue.component("top-header", {
    template: topHeaderHtml()
});

function topHeaderHtml() {
    return '<div id="top-header"> <dv-decoration-8 class="header-left-decoration" /> <dv-decoration-5 class="header-center-decoration" /> <dv-decoration-8 class="header-right-decoration" :reverse="true" /> <div class="center-title">施工养护综合数据</div> </div>';
}

var digitalFlop = ur.vueExtend({
    template:'<div id="digital-flop"> <div class="digital-flop-item" v-for="item in digitalFlopData" :key="item.title" > <div class="digital-flop-title">{{ item.title }}</div> <div class="digital-flop"> <dv-digital-flop :config="item.number" style="width:100px;height:50px;" /> <div class="unit">{{ item.unit }}</div> </div> </div> <dv-decoration-10 /> </div>',
    data:{
        digitalFlopData: [],
        querySetting:{
            queryCode:"test-digital-flop",
            objKey:"digitalFlopData"
        }
    },
    setIntervalTime:3000000
});

// var digitalFlop = Vue.extend({
//     template: `<div id="digital-flop"> <div class="digital-flop-item" v-for="item in digitalFlopData" :key="item.title" > <div class="digital-flop-title">{{ item.title }}</div> <div class="digital-flop"> <dv-digital-flop :config="item.number" style="width:100px;height:50px;" /> <div class="unit">{{ item.unit }}</div> </div> </div> <dv-decoration-10 /> </div>`,
//     data() {
//         return {
//             digitalFlopData: [],
//             querySetting:{
//                 queryCode:"test-digital-flop",
//                 objKey:"digitalFlopData"
//             }
//         }
//     },
//     methods: {
//         createData(){
//             ur.setResponseData(this);
//         }
//     },
//     mounted() {
//         const {createData} = this;
//         createData();
//         setInterval(createData, 3000000);
//     }
// });

var rankingBoard = ur.vueExtend({
    template:'<div id="ranking-board"> <div class="ranking-board-title">巡查上报记录数量</div> <dv-scroll-ranking-board :config="rankingBoardConfig" /> </div>',
    data:{
        rankingBoardConfig: {},
        querySetting:{
            queryCode:"test-ranking-board",
            objKey:"rankingBoardConfig"
        }
    }
});

// var rankingBoard = Vue.extend({
//     template: `<div id="ranking-board"> <div class="ranking-board-title">巡查上报记录数量</div> <dv-scroll-ranking-board :config="rankingBoardConfig" /> </div>`,
//     data() {
//         return {
//             rankingBoardConfig: {},
//             querySetting:{
//                 queryCode:"test-ranking-board",
//                 objKey:"rankingBoardConfig"
//             }
//         }
//     },
//     methods: {
//         createData() {
//             ur.setResponseData(this);
//         }
//     },
//     mounted() {
//         const {createData} = this;
//         createData();
//     }
// });

var roseChart = Vue.extend({
    template: `<div id="rose-chart"> <div class="rose-chart-title">累计计量资金分布</div> <dv-charts :option="roseChartOption" /> </div>`,
    data() {
        return {
            roseChartOption: {},
            querySetting:{
                queryCode:"test-rose-chart",
                objKey:"roseChartOption"
            }
        }
    },
    methods: {
        createData() {
            ur.setResponseData(this);
        }
    },
    mounted() {
        const {createData} = this
        createData()
        setInterval(createData, 50000)
    }
});

var waterLevelChart = Vue.extend({
    template: `<div id="water-level-chart"> <div class="water-level-chart-title">计划资金累计完成情况</div> <div class="water-level-chart-details"> 累计完成<span>235,680</span>元 </div> <div class="chart-container"> <dv-water-level-pond :config="waterLevelChartConfig" /> </div> </div>`,
    data() {
        return {
            waterLevelChartConfig: {},
            querySetting:{
                queryCode:"test-water-level-chart",
                objKey:"waterLevelChartConfig"
            }
        }
    },
    methods: {
        createData() {
            ur.setResponseData(this);
        }
    },
    mounted() {
        const {createData} = this
        createData()
        setInterval(createData, 60000)
    }
});

var scrollBoard = Vue.extend({
    template: `<div id="scroll-board"> <dv-scroll-board :config="scrollBoardConfig" /> </div>`,
    data() {
        return {
            scrollBoardConfig: {},
            querySetting:{
                queryCode:"test-scroll-board",
                objKey:"scrollBoardConfig"
            }
        }
    },
    methods: {
        createData() {
            ur.setResponseData(this);
        }
    },
    mounted() {
        const {createData} = this
        createData()
        setInterval(createData, 60000)
    }
});


var cards = Vue.extend({
    template: `<div id="cards"> <div class="card-item" v-for="(card, i) in cards" :key="card.title" > <div class="card-header"> <div class="card-header-left">{{ card.title }}</div> <div class="card-header-right">{{ '0' + (i + 1) }}</div> </div> <dv-charts class="ring-charts" :option="card.ring" /> <div class="card-footer"> <div class="card-footer-item"> <div class="footer-title">累计金额</div> <div class="footer-detail"> <dv-digital-flop :config="card.total" style="width:70%;height:35px;" />元 </div> </div> <div class="card-footer-item"> <div class="footer-title">巡查病害</div> <div class="footer-detail"> <dv-digital-flop :config="card.num" style="width:70%;height:35px;" />处 </div> </div> </div> </div> </div>`,
    data() {
        return {
            cards: [],
            querySetting:{
                queryCode:"test-cards",
                objKey:"cards"
            }
        }
    },
    methods: {
        createData() {
            ur.setResponseData(this);

            const {randomExtend} = this

            this.cards = new Array(5).fill(0).map((foo, i) => ({
                title: '测试路段' + (i + i),
                total: {
                    number: [randomExtend(9000, 10000)],
                    content: '{nt}',
                    textAlign: 'right',
                    style: {
                        fill: '#ea6027',
                        fontWeight: 'bold'
                    }
                },
                num: {
                    number: [randomExtend(30, 60)],
                    content: '{nt}',
                    textAlign: 'right',
                    style: {
                        fill: '#26fcd8',
                        fontWeight: 'bold'
                    }
                },
                ring: {
                    series: [{
                        type: 'gauge',
                        startAngle: -Math.PI / 2,
                        endAngle: Math.PI * 1.5,
                        arcLineWidth: 13,
                        radius: '80%',
                        data: [
                            {name: '资金占比', value: randomExtend(40, 60)}
                        ],
                        axisLabel: {
                            show: false
                        },
                        axisTick: {
                            show: false
                        },
                        pointer: {
                            show: false
                        },
                        backgroundArc: {
                            style: {
                                stroke: '#224590'
                            }
                        },
                        details: {
                            show: true,
                            formatter: '资金占比{value}%',
                            style: {
                                fill: '#1ed3e5',
                                fontSize: 20
                            }
                        }
                    }],
                    color: ['#03d3ec']
                }
            }))
        },
        randomExtend(minNum, maxNum) {
            if (arguments.length === 1) {
                return parseInt(Math.random() * minNum + 1, 10)
            } else {
                return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10)
            }
        }
    },
    mounted() {
        const {createData} = this

        createData()
        console.log(this.cards);
        setInterval(this.createData, 30000)
    }
});


var app = new Vue({
    el: '#app',
    components: {
        'digitalFlop': digitalFlop,
        'rankingBoard': rankingBoard,
        'roseChart': roseChart,
        'waterLevelChart': waterLevelChart,
        'scrollBoard': scrollBoard,
        'cards': cards
    }

});


function randomExtend(minNum, maxNum) {
    if (arguments.length === 1) {
        return parseInt(Math.random() * minNum + 1, 10)
    } else {
        return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10)
    }
}




