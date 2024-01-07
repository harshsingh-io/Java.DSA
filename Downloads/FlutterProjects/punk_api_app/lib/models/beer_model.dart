// lib/models/beer_model.dart
class BeerModel {
  final int id;
  final String name;
  final double abv;
  final double ibu;
  final String imageUrl;
  final String tagline;
  final String description;
  final String brewingMethod;
  final List<String> ingredients;
  final List<String> foodPairing;
  final String brewersTips;

  BeerModel({
    required this.id,
    required this.name,
    required this.abv,
    required this.ibu,
    required this.imageUrl,
    required this.tagline,
    required this.description,
    required this.brewingMethod,
    required this.ingredients,
    required this.foodPairing,
    required this.brewersTips,
  });

  // Factory method to create an instance from a JSON map
  factory BeerModel.fromJson(Map<String, dynamic> json) {
    return BeerModel(
      id: json['id'],
      name: json['name'],
      abv: (json['abv'] ?? 0.0).toDouble(),
      ibu: (json['ibu'] ?? 0.0).toDouble(),
      imageUrl: json['image_url'],
      tagline: json['tagline'] ?? '',
      description: json['description'] ?? '',
      brewingMethod:
          '${json['method']['mash_temp'][0]['temp']['value']}°C for ${json['method']['mash_temp'][0]['duration']} minutes',
      ingredients: (json['ingredients']['malt'] as List<dynamic>)
          .map((ingredient) => ingredient['name'].toString())
          .toList(),
      foodPairing: json['food_pairing'].cast<String>(),
      brewersTips: json['brewers_tips'] ?? '',
    );
  }
}
