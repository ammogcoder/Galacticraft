package micdoodle8.mods.galacticraft.planets.venus.world.gen.layer;

import micdoodle8.mods.galacticraft.core.world.gen.IntCache;
import micdoodle8.mods.galacticraft.planets.venus.world.gen.BiomeVenus;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerVenusBiomes extends GenLayer
{
    private static final Biome[] biomes = new Biome[] { BiomeVenus.venusFlat, BiomeVenus.venusMountain, BiomeVenus.venusValley};

    public GenLayerVenusBiomes(long l, GenLayer parent)
    {
        super(l);
        this.parent = parent;
    }

    public GenLayerVenusBiomes(long l)
    {
        super(l);
    }

    @Override
    public int[] getInts(int x, int z, int width, int depth)
    {
        int[] dest = IntCache.a(width * depth);

        for (int k = 0; k < depth; ++k)
        {
            for (int i = 0; i < width; ++i)
            {
                initChunkSeed(x + i, z + k);
                dest[i + k * width] = Biome.getIdForBiome(biomes[nextInt(biomes.length)]);
            }
        }

        return dest;
    }
}
