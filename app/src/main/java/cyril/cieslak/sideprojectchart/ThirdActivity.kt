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

class ThirdActivity : AppCompatActivity() {

    private var chart: CombinedChart? = null
    private val count = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // Change Activity Button Listener
        button_change_activity.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        combinedFingerCrossed()

    }



    fun combinedFingerCrossed (){

        title = "Weather Forecast Today"

        chart = findViewById(R.id.chartCombinedTest)
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

    class MyTempValueFormatter: IValueFormatter {

        private val mFormat: DecimalFormat
        init{
            mFormat = DecimalFormat("###,###,##0.0") // use one decimal
        }

        override fun getFormattedValue(value:Float, entry: Entry, dataSetIndex:Int, viewPortHandler: ViewPortHandler):String {
            // write your logic here
            return mFormat.format(value) + " $" // e.g. append a dollar-sign
        }
    }
}
