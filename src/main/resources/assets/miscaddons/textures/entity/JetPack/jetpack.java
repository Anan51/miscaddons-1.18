// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class steve<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "steve"), "main");
	private final ModelPart Jetpack;

	public steve(ModelPart root) {
		this.Jetpack = root.getChild("Jetpack");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Jetpack = partdefinition.addOrReplaceChild("Jetpack", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mountingplates = Jetpack.addOrReplaceChild("mountingplates", CubeListBuilder.create().texOffs(11, 14).addBox(-3.5F, -20.0F, 2.0F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 0).addBox(-3.0F, -23.0F, 1.65F, 6.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition mainbooster = Jetpack.addOrReplaceChild("mainbooster", CubeListBuilder.create().texOffs(0, 33).addBox(-0.5F, -4.375F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 32).addBox(0.0F, -3.925F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 19).addBox(-0.5F, -3.925F, -0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 17).addBox(-1.0F, -3.925F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 15).addBox(-0.5F, -3.925F, 0.125F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -3.125F, -0.875F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(31, 30).addBox(-0.5F, 1.625F, 0.125F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 28).addBox(-1.0F, 1.625F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 31).addBox(-0.5F, 1.625F, -0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 26).addBox(0.0F, 1.625F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 24).addBox(-0.5F, 2.375F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 22).addBox(-0.5F, 2.925F, 0.125F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 31).addBox(-1.0F, 2.925F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 31).addBox(-0.5F, 2.925F, -0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 10).addBox(0.0F, 2.925F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 31).addBox(-0.5F, 3.175F, -0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 7).addBox(-1.0F, 3.175F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 31).addBox(-0.5F, 3.175F, 0.125F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(31, 0).addBox(0.0F, 3.175F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 20).addBox(-1.0F, 4.175F, -0.875F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.625F, 3.875F));

		PartDefinition rightbooster = Jetpack.addOrReplaceChild("rightbooster", CubeListBuilder.create().texOffs(0, 31).addBox(4.5F, -4.8333F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 13).addBox(5.0F, -4.5333F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 5).addBox(4.5F, -4.5333F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 3).addBox(4.0F, -4.5333F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 29).addBox(4.5F, -4.5333F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(4.0F, -4.0833F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(29, 20).addBox(5.0F, -0.5333F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(29, 18).addBox(4.5F, -0.5333F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(29, 16).addBox(4.0F, -0.5333F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 29).addBox(4.5F, -0.5333F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 29).addBox(4.5F, 0.4167F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 29).addBox(4.0F, 0.7667F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 27).addBox(4.5F, 0.7667F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 25).addBox(4.5F, 0.7667F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 23).addBox(5.0F, 0.7667F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(4.0F, 1.7667F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.25F, -16.9167F, 4.0F));

		PartDefinition leftbooster = Jetpack.addOrReplaceChild("leftbooster", CubeListBuilder.create().texOffs(28, 11).addBox(-5.5F, -4.8333F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 9).addBox(-5.0F, -4.5833F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 1).addBox(-5.5F, -4.5833F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 27).addBox(-6.0F, -4.5833F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(27, 14).addBox(-5.5F, -4.5833F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-6.0F, -4.0833F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 27).addBox(-5.5F, 0.4167F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 27).addBox(-5.0F, -0.5833F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(27, 6).addBox(-5.5F, -0.5833F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(27, 4).addBox(-6.0F, -0.5833F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 21).addBox(-5.5F, -0.5833F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 17).addBox(-5.5F, 0.7667F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(25, 19).addBox(-6.0F, 0.7667F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 25).addBox(-5.5F, 0.7667F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 25).addBox(-5.0F, 0.7667F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(-6.0F, 1.7667F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(7.25F, -16.9167F, 4.0F));

		PartDefinition straps = Jetpack.addOrReplaceChild("straps", CubeListBuilder.create().texOffs(24, 23).addBox(2.0F, -5.6F, 1.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 23).addBox(-3.0F, -5.6F, 1.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 4).addBox(-4.5F, 3.4F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 20).addBox(-3.0F, -6.1F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(2.0F, -6.1F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 18).addBox(3.5F, 3.4F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(11, 12).addBox(-4.0F, 3.4F, -2.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 10).addBox(-4.0F, 3.4F, 1.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.4F, 0.0F));

		PartDefinition Body_r1 = straps.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(3.5F, 0.0F, -9.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-1.5F, 0.0F, -9.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -6.1F, -2.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition details = Jetpack.addOrReplaceChild("details", CubeListBuilder.create().texOffs(6, 25).addBox(-3.25F, 1.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(25, 2).addBox(-3.25F, 2.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(25, 0).addBox(3.25F, 2.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 20).addBox(3.25F, 1.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 18).addBox(1.5F, 1.25F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(1.5F, 2.75F, 0.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 20).addBox(-1.5F, 2.75F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 20).addBox(-1.5F, 1.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 22).addBox(-0.5F, 6.0F, -5.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-1.0F, 6.0F, -5.95F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(5, 17).addBox(1.0F, 6.0F, -5.95F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -21.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Jetpack.render(poseStack, buffer, packedLight, packedOverlay);
	}
}