package cyril.cieslak.sideprojectchart

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.LargeValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.ViewPortHandler
import kotlinx.android.synthetic.main.activity_grouped_stacked.*
import java.text.DecimalFormat

class GroupedStackedActivity : AppCompatActivity() {

    private var chart: CombinedChart? = null
    private val count = 12


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grouped_stacked)

        // Change Activity Button Listener
        button_change_activity.setOnClickListener {

            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        barsOnly()
        combinedFingerCrossed()

    }

    fun barsOnly  (){

        val barWidth: Float
        val barSpace: Float
        val groupSpace: Float
        val groupCount = 12

        barWidth = 0.15f
        barSpace = 0.07f
        groupSpace = 0.56f

        // 1. Enter the chart into the scope
        var barChartView = findViewById<BarChart>(R.id.chartConsumptionGraph)


        // 2. Define the X axis values
        var xAxisValues = ArrayList<String>()
        xAxisValues.add("Jan")
        xAxisValues.add("Feb")
        xAxisValues.add("Mar")
        xAxisValues.add("Apr")
        xAxisValues.add("May")
        xAxisValues.add("June")
        xAxisValues.add("Jul")
        xAxisValues.add("Aug")
        xAxisValues.add("Sep")
        xAxisValues.add("Oct")
        xAxisValues.add("Nov")
        xAxisValues.add("Dec")


        // 3. Define Y axis and Stacked Datas

        var yValueGroup1 = ArrayList<BarEntry>()
        var yValueGroup2 = ArrayList<BarEntry>()


        yValueGroup1.add(BarEntry(1f, floatArrayOf(9.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(1f, floatArrayOf(2.toFloat(), 7.toFloat())))


        yValueGroup1.add(BarEntry(2f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(2f, floatArrayOf(4.toFloat(), 15.toFloat())))

        yValueGroup1.add(BarEntry(3f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(3f, floatArrayOf(4.toFloat(), 15.toFloat())))

        yValueGroup1.add(BarEntry(4f, floatArrayOf(3.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(4f, floatArrayOf(4.toFloat(), 15.toFloat())))


        yValueGroup1.add(BarEntry(5f, floatArrayOf(9.toFloat(), 3.toFloat())))
        yValueGroup2.add(BarEntry(5f, floatArrayOf(10.toFloat(), 6.toFloat())))

        yValueGroup1.add(BarEntry(6f, floatArrayOf(11.toFloat(), 1.toFloat())))
        yValueGroup2.add(BarEntry(6f, floatArrayOf(12.toFloat(), 2.toFloat())))


        yValueGroup1.add(BarEntry(7f, floatArrayOf(11.toFloat(), 7.toFloat())))
        yValueGroup2.add(BarEntry(7f, floatArrayOf(12.toFloat(), 12.toFloat())))


        yValueGroup1.add(BarEntry(8f, floatArrayOf(11.toFloat(), 9.toFloat())))
        yValueGroup2.add(BarEntry(8f, floatArrayOf(12.toFloat(), 8.toFloat())))


        yValueGroup1.add(BarEntry(9f, floatArrayOf(11.toFloat(), 13.toFloat())))
        yValueGroup2.add(BarEntry(9f, floatArrayOf(12.toFloat(), 12.toFloat())))

        yValueGroup1.add(BarEntry(10f, floatArrayOf(11.toFloat(), 2.toFloat())))
        yValueGroup2.add(BarEntry(10f, floatArrayOf(12.toFloat(), 7.toFloat())))

        yValueGroup1.add(BarEntry(11f, floatArrayOf(11.toFloat(), 6.toFloat())))
        yValueGroup2.add(BarEntry(11f, floatArrayOf(12.toFloat(), 5.toFloat())))

        yValueGroup1.add(BarEntry(12f, floatArrayOf(11.toFloat(), 2.toFloat())))
        yValueGroup2.add(BarEntry(12f, floatArrayOf(12.toFloat(), 3.toFloat())))


        // 4. Group the Datas

        var barDataSet1: BarDataSet
        var barDataSet2: BarDataSet


        barDataSet1 = BarDataSet(yValueGroup1, "")
        barDataSet1.setColors(Color.BLUE, Color.RED)

        barDataSet1.setDrawIcons(false)
        barDataSet1.setDrawValues(false)

        barDataSet2 = BarDataSet(yValueGroup2, "")
        barDataSet2.setColors(Color.YELLOW, Color.RED)
        barDataSet2.setDrawIcons(false)
        barDataSet2.setDrawValues(false)


        // Pass Both Bar Data Set's in Bar Data.
        var barData = BarData(barDataSet1, barDataSet2)

        barChartView.description.isEnabled = false
        barChartView.description.textSize = 0f
        barData.setValueFormatter(LargeValueFormatter())
        barChartView.setData(barData)
        barChartView.getBarData().setBarWidth(barWidth)
        barChartView.getXAxis().setAxisMinimum(0f)
        barChartView.getXAxis().setAxisMaximum(12f)
        barChartView.groupBars(0f, groupSpace, barSpace)
        //   barChartView.setFitBars(true)
        barChartView.getData().setHighlightEnabled(false)
        barChartView.invalidate()



        // 5. Customize Bar Chart Legends using Legend Entry

        // set bar label
        var legend = barChartView.legend
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM)
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT)
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL)
        legend.setDrawInside(false)

        var legenedEntries = arrayListOf<LegendEntry>()

        legenedEntries.add(LegendEntry("2016", Legend.LegendForm.SQUARE, 8f, 8f, null, Color.RED))
        legenedEntries.add(LegendEntry("2017", Legend.LegendForm.SQUARE, 8f, 8f, null, Color.YELLOW))

        legend.setCustom(legenedEntries)

        legend.setYOffset(2f)
        legend.setXOffset(2f)
        legend.setYEntrySpace(0f)
        legend.setTextSize(5f)


        // 6. Populate X Axis Datas

        val xAxis = barChartView.getXAxis()
        xAxis.setGranularity(1f)
        xAxis.setGranularityEnabled(true)
        xAxis.setCenterAxisLabels(true)
        xAxis.setDrawGridLines(true)
        xAxis.textSize = 9f

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setValueFormatter(IndexAxisValueFormatter(xAxisValues))

        xAxis.setLabelCount(12)
        xAxis.mAxisMaximum = 12f
        xAxis.setCenterAxisLabels(true)
        xAxis.setAvoidFirstLastClipping(true)
        xAxis.spaceMin = 4f
        xAxis.spaceMax = 4f


        // 7. Modify Y Axis

        val leftAxis = barChartView.getAxisLeft()
        leftAxis.setValueFormatter(LargeValueFormatter())
        leftAxis.setDrawGridLines(false)
        leftAxis.setSpaceTop(1f)
        leftAxis.setAxisMinimum(0f)

        barChartView.data = barData
        barChartView.setVisibleXRange(1f, 12f)


    }

    fun combinedFingerCrossed (){

        title = "Weather Forecast Today"

        chart = findViewById(R.id.chartCombined)
        chart!!.description.isEnabled = false
        chart!!.setBackgroundColor(Color.WHITE)
        chart!!.setDrawGridBackground(false)
        chart!!.setDrawBarShadow(false)
        chart!!.setDrawValueAboveBar(false)
        chart!!.isHighlightFullBarEnabled = false

        // draw bars behind lines
        chart!!.drawOrder = arrayOf(CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.BUBBLE, CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE, CombinedChart.DrawOrder.SCATTER)

        val l = chart!!.legend
        l.isWordWrapEnabled = true
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)

        val rightAxis = chart!!.axisRight
        rightAxis.setDrawGridLines(false)
        rightAxis.axisMinimum = 0f // this replaces setStartAtZero(true)
        rightAxis.granularity = 5f
        rightAxis.isGranularityEnabled = true

        rightAxis.setTextColor(Color.rgb(76, 175, 80))


        val leftAxis = chart!!.axisLeft
        leftAxis.setDrawGridLines(false)
        leftAxis.axisMinimum = 0f // this replaces setStartAtZero(true)
        leftAxis.granularity = 5f
        leftAxis.isGranularityEnabled = true

        leftAxis.setTextColor(Color.rgb(66, 165, 245))


        var xAxisValues = ArrayList<String>()
        xAxisValues.add(0 , "0")
        xAxisValues.add(1, "3h")
        xAxisValues.add(2, "6h")
        xAxisValues.add(3, "9h")
        xAxisValues.add(4, "12h")
        xAxisValues.add(5, "15h")
        xAxisValues.add(6, "18h")
        xAxisValues.add(7, "21h")

        val xAxis = chart!!.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.axisMinimum = -0.5f
        xAxis.axisMaximum = 0.5f
        xAxis.granularity = 1f
        xAxis.setValueFormatter(IndexAxisValueFormatter(xAxisValues))



        val data = CombinedData()

        data.setData(generateLineData())
        data.setData(generateBarData())
        data.setData(generateBubbleData())


        xAxis.axisMaximum = data.xMax + 0.25f

        chart!!.data = data
        chart!!.invalidate()

    }

    private fun generateLineData(): LineData {

        val d = LineData()

        val entries1 = java.util.ArrayList<Entry>()


        entries1.add(Entry(0F, 4F))
        entries1.add(Entry(1F, 3F))
        entries1.add(Entry(2F, 3F))
        entries1.add(Entry(3F, 4F))
        entries1.add(Entry(4F, 5F))
        entries1.add(Entry(5F, 7F))
        entries1.add(Entry(6F, 7F))
        entries1.add(Entry(7F, 6F))



        val set1 = LineDataSet(entries1, "Wind km/h")
        set1.color = Color.rgb(76, 175, 80)
        set1.lineWidth = 2.5f
//        set1.setCircleColor(Color.rgb(240, 238, 70))
//        set1.circleRadius = 5f
      //  set1.fillColor = Color.rgb(240, 238, 70)
        set1.mode = LineDataSet.Mode.LINEAR
        set1.setDrawValues(false)
//        set1.valueTextSize = 10f
//        set1.valueTextColor = Color.rgb(240, 238, 70)

        set1.setDrawFilled(true)

        set1.axisDependency = YAxis.AxisDependency.LEFT

            d.addDataSet(set1)


        return d
    }

    private fun generateBarData(): BarData {

        val entries1 = java.util.ArrayList<BarEntry>()

        entries1.add(BarEntry(0F, 6F))
        entries1.add(BarEntry(1F, 6F))
        entries1.add(BarEntry(2F, 6F))
        entries1.add(BarEntry(3F, 7F))
        entries1.add(BarEntry(4F, 9F))
        entries1.add(BarEntry(5F, 10F))
        entries1.add(BarEntry(6F, 8F))
        entries1.add(BarEntry(7F, 7F))

        val set1 = BarDataSet(entries1, "Temperature °C")
        set1.color = Color.rgb(66, 165, 245)
      // set1.color = Color.rgb(179, 229, 252)
        set1.valueTextColor = Color.WHITE
        set1.valueTextSize = 10f
        set1.axisDependency = YAxis.AxisDependency.LEFT
        set1.setDrawValues(true)


        val barWidth = 0.9f // x2 dataset

        val d = BarData(set1)
        d.barWidth = barWidth

        return d
    }

    private fun generateScatterData(): ScatterData {

        val d = ScatterData()

        val entries = java.util.ArrayList<Entry>()

//        var index = 0f
//        while (index < count) {
//            entries.add(Entry(index + 0.25f, random(10f, 55f)))
//            index += 0.5f
//        }

        entries.add(Entry(0F, 12F))

        val set = ScatterDataSet(entries, "Scatter DataSet")
        set.setColors(*ColorTemplate.MATERIAL_COLORS)
        set.scatterShapeSize = 7.5f
        set.setDrawValues(false)
        set.valueTextSize = 10f
        d.addDataSet(set)

        return d
    }

    private fun generateCandleData(): CandleData {

        val d = CandleData()

        val entries = java.util.ArrayList<CandleEntry>()

//        var index = 0
//        while (index < count) {
//            entries.add(CandleEntry(index + 1f, 90f, 70f, 85f, 75f))
//            index += 2
//        }

        entries.add(CandleEntry(1F,  90f, 70f, 85f, 75f))

        val set = CandleDataSet(entries, "Candle DataSet")
        set.decreasingColor = Color.rgb(142, 150, 175)
        set.shadowColor = Color.DKGRAY
        set.barSpace = 0.3f
        set.valueTextSize = 10f
        set.setDrawValues(false)
        d.addDataSet(set)

        return d
    }

    private fun generateBubbleData(): BubbleData {

        val bd = BubbleData()

        val entries = java.util.ArrayList<BubbleEntry>()

//        for (index in 0 until count) {
//            val y = random(10f, 105f)
//            val size = random(100f, 105f)
//            entries.add(BubbleEntry(index + 0.5f, y, size))
//        }

        // test des bubble

        var zero = 73f
        var first = 73f
        var second = 82f
        var third = 86f
        var fourfth = 83f
        var fifth = 69f
        var sixth = 64f
        var seventh = 65f

        var biggestFigure = 10f
        var valueBiggestPlusThree = biggestFigure.plus(3f)

            entries.add(BubbleEntry(0F, valueBiggestPlusThree, zero))
            entries.add(BubbleEntry(1F, valueBiggestPlusThree, first))
            entries.add(BubbleEntry(2F, valueBiggestPlusThree, second))
            entries.add(BubbleEntry(3F, valueBiggestPlusThree, third))
            entries.add(BubbleEntry(4F, valueBiggestPlusThree, fourfth))
            entries.add(BubbleEntry(5F, valueBiggestPlusThree, fifth))
        entries.add(BubbleEntry(6F, valueBiggestPlusThree, sixth))
        entries.add(BubbleEntry(7F, valueBiggestPlusThree, seventh))



        val set = BubbleDataSet(entries, "Humidity %")
        set.setColors(*ColorTemplate.MATERIAL_COLORS)
        set.valueTextSize = 10f
        set.valueTextColor = Color.BLUE
        set.highlightCircleWidth = 1.5f
        set.setDrawValues(true)
        bd.addDataSet(set)

        return bd
    }

     class myValueTemperatureFormatter (): IValueFormatter {
        override fun getFormattedValue(
            value: Float,
            entry: Entry?,
            dataSetIndex: Int,
            viewPortHandler: ViewPortHandler?
        ): String {

            var valueToInt = value.toInt()
           return "$valueToInt + °C"
        }
    }

    class MyTempValueFormatter:IValueFormatter {

        private val mFormat: DecimalFormat
        init{
            mFormat = DecimalFormat("###,###,##0.0") // use one decimal
        }

        override fun getFormattedValue(value:Float, entry:Entry, dataSetIndex:Int, viewPortHandler:ViewPortHandler):String {
            // write your logic here
            return mFormat.format(value) + " $" // e.g. append a dollar-sign
        }
    }
}
