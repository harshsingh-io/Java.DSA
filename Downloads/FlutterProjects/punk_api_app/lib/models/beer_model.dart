// lib/models/beer_model.dart
class BeerModel {
  final int id;
  final String name;
  final double abv;
  final double ibu;
  final String imageUrl;

  BeerModel({
    required this.id,
    required this.name,
    required this.abv,
    required this.ibu,
    required this.imageUrl,
  });

  // Factory method to create an instance from a JSON map
  factory BeerModel.fromJson(Map<String, dynamic> json) {
    return BeerModel(
      id: json['id'],
      name: json['name'],
      abv: (json['abv'] ?? 0.0).toDouble(),
      ibu: (json['ibu'] ?? 0.0).toDouble(),
      imageUrl: json['image_url'],
    );
  }
}
