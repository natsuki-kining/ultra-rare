Vue.component("top-header", {
    template: topHeaderHtml()
});

function topHeaderHtml(){
    ur.query('query-user-where');
    return '<div id="top-header"> <dv-decoration-8 class="header-left-decoration" /> <dv-decoration-5 class="header-center-decoration" /> <dv-decoration-8 class="header-right-decoration" :reverse="true" /> <div class="center-title">施工养护综合数据</div> </div>';
}

var digitalFlop = Vue.extend({
    template: `<div id="digital-flop"> <div class="digital-flop-item" v-for="item in digitalFlopData" :key="item.title" > <div class="digital-flop-title">{{ item.title }}</div> <div class="digital-flop"> <dv-digital-flop :config="item.number" style="width:100px;height:50px;" /> <div class="unit">{{ item.unit }}</div> </div> </div> <dv-decoration-10 /> </div>`,
    data() {
        return {
            digitalFlopData: []
        }
    },
    methods: {
        createData() {
            this.digitalFlopData = getDigitalFlopData();
        }
    },
    mounted() {
        const { createData } = this;
        createData();
        setInterval(createData, 3000);
    }
});


var rankingBoard = Vue.extend({
    template: `<div id="ranking-board"> <div class="ranking-board-title">巡查上报记录数量</div> <dv-scroll-ranking-board :config="rankingBoardConfig" /> </div>`,
    data() {
        return {
            rankingBoardConfig: {
                data: [{
                        name: '日常养护',
                        value: 55
                    },
                    {
                        name: '交通事故',
                        value: 120
                    },
                    {
                        name: '路面',
                        value: 78
                    },
                    {
                        name: '桥通',
                        value: 66
                    },
                    {
                        name: '计日工',
                        value: 80
                    },
                    {
                        name: '路基',
                        value: 45
                    },
                    {
                        name: '交安设施',
                        value: 29
                    },
                    {
                        name: '除雪',
                        value: 29
                    },
                    {
                        name: '绿化',
                        value: 29
                    }
                ],
                rowNum: 9
            }
        }
    }
});

var roseChart = Vue.extend({
    template: `<div id="rose-chart"> <div class="rose-chart-title">累计计量资金分布</div> <dv-charts :option="option" /> </div>`,
    data() {
        return {
            option: {}
        }
    },
    methods: {
        createData() {
            const { randomExtend } = this

            this.option = {
                series: [{
                    type: 'pie',
                    radius: '50%',
                    roseSort: false,
                    data: [
                        { name: '路基', value: randomExtend(40, 70) },
                        { name: '交安设施', value: randomExtend(20, 30) },
                        { name: '日常养护', value: randomExtend(10, 50) },
                        { name: '桥通', value: randomExtend(5, 20) },
                        { name: '交通事故', value: randomExtend(40, 50) },
                        { name: '路面', value: randomExtend(20, 30) },
                        { name: '绿化', value: randomExtend(5, 10) },
                        { name: '计日工', value: randomExtend(20, 35) },
                        { name: '除雪', value: randomExtend(5, 10) }
                    ],
                    insideLabel: {
                        show: false
                    },
                    outsideLabel: {
                        formatter: '{name} {percent}%',
                        labelLineEndLength: 20,
                        style: {
                            fill: '#fff'
                        },
                        labelLineStyle: {
                            stroke: '#fff'
                        }
                    },
                    roseType: true
                }],
                color: ['#da2f00', '#fa3600', '#ff4411', '#ff724c', '#541200', '#801b00', '#a02200', '#5d1400', '#b72700']
            }
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
        const { createData } = this

        createData()

        setInterval(createData, 30000)
    }
});

var waterLevelChart = Vue.extend({
    template: `<div id="water-level-chart"> <div class="water-level-chart-title">计划资金累计完成情况</div> <div class="water-level-chart-details"> 累计完成<span>235,680</span>元 </div> <div class="chart-container"> <dv-water-level-pond :config="config" /> </div> </div>`,
    data() {
        return {
            config: {
                data: [45],
                shape: 'round',
                waveHeight: 25,
                waveNum: 2
            }
        }
    }
});

var scrollBoard = Vue.extend({
    template: `<div id="scroll-board"> <dv-scroll-board :config="config" /> </div>`,
    data() {
        return {
            config: {
                header: ['时间', '病害信息', '数量', '标段'],
                data: [
                    ['2019-07-01 19:25:00', '路面危害-松散', '5', 'xxxxxxx'],
                    ['2019-07-02 17:25:00', '路面危害-路面油污清理', '13', 'xxxxxxx'],
                    ['2019-07-03 16:25:00', '交安设施-交通标志牌结构', '6', 'xxxxxxx'],
                    ['2019-07-04 15:25:00', '路基危害-防尘网', '2', 'xxxxxxx'],
                    ['2019-07-05 14:25:00', '交安设施-交通标志牌结构', '1', 'xxxxxxx'],
                    ['2019-07-06 13:25:00', '路面危害-松散', '3', 'xxxxxxx'],
                    ['2019-07-07 12:25:00', '路基危害-防尘网', '4', 'xxxxxxx'],
                    ['2019-07-08 11:25:00', '路面危害-路面油污清理', '2', 'xxxxxxx'],
                    ['2019-07-09 10:25:00', '交安设施-交通标志牌结构', '5', 'xxxxxxx'],
                    ['2019-07-10 09:25:00', '路基危害-防尘网', '3', 'xxxxxxx']
                ],
                index: true,
                columnWidth: [50, 170, 210],
                align: ['center'],
                rowNum: 7,
                headerBGC: '#1981f6',
                headerHeight: 45,
                oddRowBGC: 'rgba(0, 44, 81, 0.8)',
                evenRowBGC: 'rgba(10, 29, 50, 0.8)'
            }
        }
    }
});


var cards = Vue.extend({
    template: `<div id="cards"> <div class="card-item" v-for="(card, i) in cards" :key="card.title" > <div class="card-header"> <div class="card-header-left">{{ card.title }}</div> <div class="card-header-right">{{ '0' + (i + 1) }}</div> </div> <dv-charts class="ring-charts" :option="card.ring" /> <div class="card-footer"> <div class="card-footer-item"> <div class="footer-title">累计金额</div> <div class="footer-detail"> <dv-digital-flop :config="card.total" style="width:70%;height:35px;" />元 </div> </div> <div class="card-footer-item"> <div class="footer-title">巡查病害</div> <div class="footer-detail"> <dv-digital-flop :config="card.num" style="width:70%;height:35px;" />处 </div> </div> </div> </div> </div>`,
    data() {
        return {
            cards: []
        }
    },
    methods: {
        createData() {
            const { randomExtend } = this

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
                            { name: '资金占比', value: randomExtend(40, 60) }
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
        const { createData } = this

        createData()

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

function getDigitalFlopData() {
    return [{
            title: '管养里程',
            number: {
                number: [randomExtend(20000, 30000)],
                content: '{nt}',
                textAlign: 'right',
                style: {
                    fill: '#4d99fc',
                    fontWeight: 'bold'
                }
            },
            unit: '公里'
        },
        {
            title: '桥梁',
            number: {
                number: [randomExtend(20, 30)],
                content: '{nt}',
                textAlign: 'right',
                style: {
                    fill: '#f46827',
                    fontWeight: 'bold'
                }
            },
            unit: '座'
        },
        {
            title: '涵洞隧道',
            number: {
                number: [randomExtend(20, 30)],
                content: '{nt}',
                textAlign: 'right',
                style: {
                    fill: '#40faee',
                    fontWeight: 'bold'
                }
            },
            unit: '个'
        },
        {
            title: '匝道',
            number: {
                number: [randomExtend(10, 20)],
                content: '{nt}',
                textAlign: 'right',
                style: {
                    fill: '#4d99fc',
                    fontWeight: 'bold'
                }
            },
            unit: '个'
        },
        {
            title: '隧道',
            number: {
                number: [randomExtend(5, 10)],
                content: '{nt}',
                textAlign: 'right',
                style: {
                    fill: '#f46827',
                    fontWeight: 'bold'
                }
            },
            unit: '个'
        },
        {
            title: '服务区',
            number: {
                number: [randomExtend(5, 10)],
                content: '{nt}',
                textAlign: 'right',
                style: {
                    fill: '#40faee',
                    fontWeight: 'bold'
                }
            },
            unit: '个'
        },
        {
            title: '收费站',
            number: {
                number: [randomExtend(5, 10)],
                content: '{nt}',
                textAlign: 'right',
                style: {
                    fill: '#4d99fc',
                    fontWeight: 'bold'
                }
            },
            unit: '个'
        },
        {
            title: '超限站',
            number: {
                number: [randomExtend(5, 10)],
                content: '{nt}',
                textAlign: 'right',
                style: {
                    fill: '#f46827',
                    fontWeight: 'bold'
                }
            },
            unit: '个'
        },
        {
            title: '停车区',
            number: {
                number: [randomExtend(5, 10)],
                content: '{nt}',
                textAlign: 'right',
                style: {
                    fill: '#40faee',
                    fontWeight: 'bold'
                }
            },
            unit: '个'
        }
    ]
}