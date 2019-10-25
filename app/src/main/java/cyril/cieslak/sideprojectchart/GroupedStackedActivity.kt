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
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.ViewPortHandler
import kotlinx.android.synthetic.main.activity_grouped_stacked.*
import java.lang.Math.random
import java.text.DecimalFormat

class GroupedStackedActivity : AppCompatActivity() {

    private var chart: CombinedChart? = null
    private val count = 12


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grouped_stacked)

        // Change Activity Button Listener
        button_change_activity.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
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

        title = "CombinedChartActivity"

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
//        xAxis.valueFormatter = object : ValueFormatter() {
//            override fun getFormattedValue(value: Float): String {
//                return value.toString()
//                //months[value.toInt() % months.size]
//
//            }
  //      }


        val data = CombinedData()

        data.setData(generateLineData())
        data.setData(generateBarData())
//        data.setData(generateBubbleData())
//        data.setData(generateScatterData())
//        data.setData(generateCandleData())
     //   data.setValueTypeface(tfLight)

        xAxis.axisMaximum = data.xMax + 0.25f

        chart!!.data = data
        chart!!.invalidate()

    }

    private fun generateLineData(): LineData {

        val d = LineData()

        val entries1 = java.util.ArrayList<Entry>()
        val entries2 = java.util.ArrayList<Entry>()
//        for (index in 0 until count)
//            entries.add(Entry(index + 0.5f, getRandom(15f, 5f)))


        entries1.add(Entry(0F, 1F))
        entries1.add(Entry(1F, 1F))
        entries1.add(Entry(2F, 2F))
        entries1.add(Entry(3F, 2F))
        entries1.add(Entry(4F, 0F))
        entries1.add(Entry(5F, 1F))
        entries1.add(Entry(6F, 1F))
        entries1.add(Entry(7F, 1F))

        entries2.add(Entry(0F, 51F))
        entries2.add(Entry(1F, 58F))
        entries2.add(Entry(2F, 62F))
        entries2.add(Entry(3F, 43F))
        entries2.add(Entry(4F, 32F))
        entries2.add(Entry(5F, 37F))
        entries2.add(Entry(6F, 45F))
        entries2.add(Entry(7F, 50F))



        val set1 = LineDataSet(entries1, "Wind km/h")
        set1.color = Color.rgb(240, 238, 70)
        set1.lineWidth = 2.5f
        set1.setCircleColor(Color.rgb(240, 238, 70))
        set1.circleRadius = 5f
        set1.fillColor = Color.rgb(240, 238, 70)
        set1.mode = LineDataSet.Mode.CUBIC_BEZIER
        set1.setDrawValues(true)
        set1.valueTextSize = 10f
        set1.valueTextColor = Color.rgb(240, 238, 70)


        set1.setDrawFilled(true)

        val set2 = LineDataSet(entries2, "Wind Speed")

        set2.color = Color.BLUE
        set2.lineWidth = 2.5f
        set2.setCircleColor(Color.BLUE)
        set2.circleRadius = 5f
        set2.fillColor = Color.BLUE
        set2.mode = LineDataSet.Mode.LINEAR
        set2.setDrawValues(true)
        set2.valueTextSize = 10f
        set2.valueTextColor = Color.BLUE


        set1.axisDependency = YAxis.AxisDependency.LEFT
        set2.axisDependency = YAxis.AxisDependency.RIGHT
       // d.addDataSet(set1)
            d.addDataSet(set1)
         //   d.addDataSet(set2)

        return d
    }

    private fun generateBarData(): BarData {

        val entries1 = java.util.ArrayList<BarEntry>()
        val entries2 = java.util.ArrayList<BarEntry>()

//        for (index in 0 until count) {
//            entries1.add(BarEntry(0f, Random(25f, 25f)))
//
//            // stacked
//            entries2.add(BarEntry(0f, floatArrayOf(random(13f, 12f), random(13f, 12f))))
//        }

        entries1.add(BarEntry(0F, 14F))
        entries1.add(BarEntry(1F, 12F))
        entries1.add(BarEntry(2F, 12F))
        entries1.add(BarEntry(3F, 19F))
        entries1.add(BarEntry(4F, 23F))
        entries1.add(BarEntry(5F, 20F))
        entries1.add(BarEntry(6F, 16F))
        entries1.add(BarEntry(7F, 15F))

        entries2.add(BarEntry(0F, 19F))
        entries2.add(BarEntry(1F, 20F))
        entries2.add(BarEntry(2F, 21F))
        entries2.add(BarEntry(3F, 22F))
        entries2.add(BarEntry(4F, 23F))
        entries2.add(BarEntry(5F, 24F))
        entries2.add(BarEntry(6F, 25F))
        entries2.add(BarEntry(7F, 26F))




        val set1 = BarDataSet(entries1, "Temperature °C")
        set1.color = Color.rgb(66, 165, 245)
        set1.valueTextColor = Color.WHITE
        set1.valueTextSize = 10f
        set1.axisDependency = YAxis.AxisDependency.LEFT
        set1.setDrawValues(true)





        val set2 = BarDataSet(entries2, "")
        set2.stackLabels = arrayOf("Stack 1", "Stack 2")
        set2.setColors(Color.rgb(61, 165, 255), Color.rgb(23, 197, 255))
        set2.valueTextColor = Color.rgb(61, 165, 255)
        set2.valueTextSize = 10f
        set2.axisDependency = YAxis.AxisDependency.LEFT

        val groupSpace = 0.06f
        val barSpace = 0.02f // x2 dataset
        val barWidth = 0.9f // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

        val d = BarData(set1)
        // ,set2
        d.barWidth = barWidth

        // make this BarData object grouped
      //  d.groupBars(0f, groupSpace, barSpace) // start at x = 0

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

        entries.add(BubbleEntry(3F, 20F, 25F))

        val set = BubbleDataSet(entries, "Bubble DataSet")
        set.setColors(*ColorTemplate.VORDIPLOM_COLORS)
        set.valueTextSize = 10f
        set.valueTextColor = Color.WHITE
        set.highlightCircleWidth = 1.5f
        set.setDrawValues(true)
        bd.addDataSet(set)

        return bd
    }

    private class myValueTemperatureFormatter (): IValueFormatter {
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
