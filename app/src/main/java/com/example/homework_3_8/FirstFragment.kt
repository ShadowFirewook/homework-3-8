package com.example.homework_3_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework_3_8.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    val carList = arrayListOf<Car>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CarsAdapter(carList,this::onClick)
        binding.resyclerView.adapter = adapter
        loadData()
    }

    private fun loadData() {
        carList.add(Car("Mercedes-Benz","https://avatars.mds.yandex.net/get-verba/787013/2a0000017c373735fe07cbba9aadd3f022fc/cattouchret","Mercedes-Benz — торговая марка и одноимённая компания — производитель легковых автомобилей премиального класса, грузовых автомобилей, автобусов и других транспортных средств, входящая в состав немецкого концерна «Daimler AG»."))
        carList.add(Car("Porsche","https://files.porsche.com/filestore/image/multimedia/none/carrange-flyout-cayenne/small/46131fe5-6694-11e9-80c4-005056bbdc38;sQ;twebp;c1696;gc/porsche-small.webp","Porsche AG — немецкий производитель автомобилей и солнцезащитных очков, основанный конструктором Фердинандом Порше в 1931 году, в настоящее время — дочерняя структура Porsche Automobil Holding"))
        carList.add(Car("BMW","https://avatars.mds.yandex.net/get-verba/1540742/2a00000180d7fa047e2e09e71e665301c310/cattouch","BMW AG рус. Бэ-Эм-Вэ́ — немецкий производитель автомобилей, мотоциклов, двигателей, а также велосипедов. Более 45 % акций принадлежит семье Квандт."))
        carList.add(Car("Daewoo","https://avatars.mds.yandex.net/get-verba/216201/2a000001609c547945f517f6126bd3742180/cattouch","Daewoo — один из крупнейших южнокорейских чеболей. Компания основана 22 марта 1967 года под названием Daewoo Industrial."))
        carList.add(Car("Lexus","https://motor.ru/thumb/1500x0/filters:quality(75):no_upscale()/imgs/2021/06/26/08/4735888/120e90f5fc68e3d18419f1f13d17043abbe6db72.jpeg","Lexus — марка премиальных автомобилей, производимых японской корпорацией Toyota Motor. Автомобили бренда продаются более чем в 90 странах мира. "))
        carList.add(Car("Toyota","https://avatars.mds.yandex.net/get-verba/1030388/2a000001786ab6d740f53ca6259ae80885c7/cattouchret","Toyota Motor Corporation — крупнейшая японская автомобилестроительная корпорация, также предоставляющая финансовые услуги и имеющая несколько дополнительных направлений в бизнесе."))
        carList.add(Car("Lada","https://i.ytimg.com/vi/-KYpTR43H24/maxresdefault.jpg","Lada — марка автомобилей, производимых АО «АвтоВАЗ». Ранее использовалась только для автомобилей, поставлявшихся на экспорт, а для внутреннего рынка автомобили производились под маркой «Жигули»"))
        carList.add(Car("Chevrolet","https://avatars.mds.yandex.net/get-verba/3587101/2a000001805ff9b2443cb3ed6c2f241598a7/cattouchret","Chevrolet, — марка автомобилей, производимых и реализуемых одноимённым экономически самостоятельным подразделением корпорации General Motors."))
    }

    fun onClick(position: Int){
        val car = carList[position]
        val bundle = Bundle()
        bundle.putSerializable("car",car)
        findNavController().navigate(R.id.secondFragment,bundle)
    }
}