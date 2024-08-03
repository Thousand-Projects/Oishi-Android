package com.uiel.oishi

object Data {
    val data = listOf(
        FoodItem(
            image = R.drawable.ufo,
            title = "UFO 야끼소바",
            description = "일본 편의점 필수 라면",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.nitsin,
            title = "닛신컵누들",
            description = "제일 유명한 컵라면, 카레맛이 근본!",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.jajipuding,
            title = "쟈지푸딩",
            description = "달달하고 부드러운 우유푸딩",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.pino_ice_cream,
            title = "피노 아이스크림",
            description = "초콜릿으로 코팅된 바닐라 아이스크림. \n" +
                    "피스타치오맛도 나왔단 사실!",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.tamago_sandwitch,
            title = "타마고샌드",
            description = "부드러운 계란이 입에서 살살 녹는 샌드위치. \n" +
                    "필수 구매템!",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.jagarico,
            title = "자가리코",
            description = "막대형 감자칩. 바삭의 끝판왕. \n" +
                    "맛도 다양해 선물용으로 최고!",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.icenomi,
            title = "아이스노미",
            description = "쫀득시원한 구슬+젤리 아이스크림",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.ohhayo_chrim,
            title = "오하요 크림 브륄레",
            description = "필수 구매템! 이거 모르는사람 없게 해주세요 ㅠㅠ",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.eyrohase,
            title = "이로하스",
            description = "과일향이 추가된 생수. 향이 강하지만 자연스러운게 특징!",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.bansuk,
            title = "반숙 주먹밥",
            description = "간장과 부드러운 반숙계란의 하모니를 느낄 수 있는 주먹밥.\n" +
                    "한끼 식사로도 문제 ㄴㄴ",
            category = Category.CONVENIENCESTORE,
        ),
        FoodItem(
            image = R.drawable.kitkat,
            title = "킷캣",
            description = "가격도 엄청 싼데 사케/치즈케잌 등 신기한 맛 가득!",
            category = Category.DONQUIJOTE,
        ),
        FoodItem(
            image = R.drawable.yosinoya,
            title = "요시노야",
            description = "가장 유명한 규동(덮밥)집.\n" +
                    "가격이 싼게 장점, 카드가 안되는게 단점",
            category = Category.RESTAURANT,
        ),
        FoodItem(
            image = R.drawable.sukiya,
            title = "스키야",
            description = "요시노야와 비슷한 규동집.\n" +
                    "키오스크(한국어 지원)로 카드결제도 쌉가능\n" +
                    "개인적으로 매운 치킨커리 = 가성비+존맛!",
            category = Category.RESTAURANT,
        ),
        FoodItem(
            image = R.drawable.mathya,
            title = "마츠야",
            description = "요시노야와 비슷한 규동집.\n" +
                    "여기도 키오스크(한국어 지원) 사용.\n" +
                    "특징은 무료 된장국",
            category = Category.RESTAURANT,
        ),
        FoodItem(
            image = R.drawable.cocochibanya,
            title = "코코이치방야",
            description = "제일 유명한 카레전문점. 무난하게 먹기 좋다.\n" +
                    "개인적으로 일본 애니 속 레스토랑 분위기랄까?",
            category = Category.RESTAURANT,
        ),
        FoodItem(
            image = R.drawable.sushiro,
            title = "스시로",
            description = "회전초밥집 3대장 중 하나.\n" +
                    "무난하게 먹기 좋음\n" +
                    "(가격도 저렴!)",
            category = Category.RESTAURANT,
        ),
        FoodItem(
            image = R.drawable.hamasushi,
            title = "하마스시",
            description = "회전초밥집 3대장 중 하나.\n" +
                    "무난하게 먹기 좋음\n" +
                    "(가격도 저렴!)",
            category = Category.RESTAURANT,
        ),
        FoodItem(
            image = R.drawable.churashushi,
            title = "쿠라스시",
            description = "회전초밥집 3대장 중 하나.\n" +
                    "무난하게 먹기 좋음\n" +
                    "(가격도 저렴!)",
            category = Category.RESTAURANT,
        ),
    )
}

class FoodItem(
    val image: Int,
    val title: String,
    val description: String,
    val category: Category,
)
